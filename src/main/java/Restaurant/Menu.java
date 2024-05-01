package Restaurant;

public class Menu {
    private String title;

    public String getTitle() {
        return title;
    }

    public Menu(String title) {
        this.title = title;
    }

    public Menu() {
    }

    public String print() {
        return ("Title of menu : " + title + '\n');
    }
}
