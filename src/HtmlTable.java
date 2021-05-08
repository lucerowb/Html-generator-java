import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HtmlTable extends Component {
    public List<Model> readValues() {

        Connection connection;
        Statement statement = null;
        ResultSet rs = null;
        List<Model> modelList = new ArrayList<>();

        PostgresSQLConnect obj_ConnectDB = new PostgresSQLConnect();

        connection = obj_ConnectDB.getConnection();

        try {
            String query = "SELECT * FROM people";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Model model = new Model();
                model.setId(rs.getLong("id"));
                model.setFirstName(rs.getString("first_name"));
                model.setMiddleName(rs.getString("middle_name"));
                model.setLastName(rs.getString("last_name"));
                model.setPhoneNumber(rs.getString("phone_num"));
                modelList.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                    assert rs != null;
                    rs.close();
                    statement.close();
                    connection.close();
                    System.out.println("connection closed");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return modelList;
    }

    public String html() {
        String tagName = "html";
        String htmlElements = this.head() + this.body() + "\n";
        return openAndCloseTag(tagName, htmlElements);
    }

    private String openAndCloseTag(String tagName, String mid) {
        return "\n" + open(tagName) + mid + close(tagName);
    }

    private String head() {
        String tagName = "head";
        String headElements = this.title() + "\n";
        return openAndCloseTag(tagName, headElements);
    }

    private String title() {
        String tagName = "title";
        String text = "HTML Table";
        return openAndCloseTag(tagName, text);
    }

    private String body() {
        String tagName = "body";
        String bodyElements = this.h1() + this.table() + "\n";
        return openAndCloseTag(tagName, bodyElements);
    }

    private String h1() {
        String tagName = "h1";
        String text = "HTML Table";
        return openAndCloseTag(tagName, text);
    }

    private String table() {
        String tagName = "table";
        String tableElements = this.trh() + "\n" + this.tr();
        return openAndCloseTag(tagName, tableElements);
    }

    private String trh() {
        String tagName = "tr";
        String rowElements = this.th("Id") + this.th("First name") + this.th("Middle name") + this.th("Last name") + this.th("Phone number") + "\n";
        return openAndCloseTag(tagName, rowElements);
    }

    private String th(String colName) {
        String tagName = "th";
        return openAndCloseTag(tagName, colName);
    }

    private String tr() {
        List<Model> modelList = this.readValues();
        String tagName = "tr";
        StringBuilder line = new StringBuilder();

        modelList.forEach(model -> {

            line.append(open(tagName));
            line.append(this.td(Long.toString(model.getId())));
            line.append(this.td(model.getFirstName()));
            line.append(this.td(model.getMiddleName()));
            line.append(this.td(model.getLastName()));
            line.append(this.td(model.getPhoneNumber()));
            line.append("\n").append(close(tagName)).append("\n");

        });

        return line.toString();

    }


    private String td(String data) {
        String tagName = "td";
        return openAndCloseTag(tagName, data);
    }

}