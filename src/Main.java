import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void main (String[] args) throws IOException {
        HtmlTag htmlTag = new HtmlTag();
        HtmlTable htmlTable = new HtmlTable();

        FileWriter table = new FileWriter("table.html");
        table.write(htmlTable.html());
        table.close();
        System.out.println("Successfully created Table file");
        FileWriter html = new FileWriter("index.html");
        html.write(htmlTag.html());
        html.close();
        System.out.println("Successfully created HTML file");
    }
}
