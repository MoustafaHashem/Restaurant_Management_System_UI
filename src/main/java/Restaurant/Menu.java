package Restaurant;

public class Menu {
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    public Menu() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String print() {
        return ("Menu: " + title + '\n');
    }
}
