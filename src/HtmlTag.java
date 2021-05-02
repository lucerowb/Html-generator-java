public class HtmlTag extends Component {

    public String html() {
        String tagName = "html";
        String htmlElements = head() + body() + "\n";
        return openAndCloseTag(tagName, htmlElements);
    }
    private String openAndCloseTag(String tagName, String mid) {
        return "\n"+open(tagName)+mid+close(tagName);
    }
    private String head() {
        String tagName ="head";
        return openAndCloseTag(tagName, title()+"\n");
    }
    private String title() {
        String tagName = "title";
        String text = "HTML Generator";
        return openAndCloseTag(tagName, text);
    }
    private String body() {
        String tagName = "body";
        String bodyElements = h1() + label() + textArea() + button() + "\n";
        return openAndCloseTag(tagName, bodyElements);
    }
    private String h1() {
        String tagName = "h1";
        String text = "Input";
        return openAndCloseTag(tagName, text);
    }
    private String label() {
        String tagName = "label";
        String text = "comment:";
        return openAndCloseTag(tagName, text) + "<br>";
    }
    private String textArea() {
        String tagName = "textarea";
        String text = "";
        return openAndCloseTag(tagName, text) + "<br>";
    }
    private String button() {
        String tagName = "button";
        String text = "Submit";
        return "\n"+open(tagName+" type = 'Submit'")+text+close(tagName);
    }
}
