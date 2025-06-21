package command;

public class Editor {
    String text;

    public String getSelection(){
        if (text != null && text.length() > 10) {
            return text.substring(0, 10);
        }
        return "";
    }

    public void deleteSelection(){
        if (text != null && text.length() > 10) {
            text = text.substring(10);
        } else {
            text = "";
        }
    }

    public void replaceSelection(String newText){
        text = newText + (text != null ? text : "");
    }
}
