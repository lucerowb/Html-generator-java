import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {
        HtmlTag htmlTag = new HtmlTag();

        FileWriter html = new FileWriter("index.html");
        html.write(htmlTag.html());
        html.close();
        System.out.println("Successfully created HTML file");
    }
}
