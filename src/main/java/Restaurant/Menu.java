package Restaurant;

public class Menu {
    private final String title;

    public String getTitle() {
        return title;
    }

    public Menu(String title) {
        this.title = title;
    }
    public void print() {
        System.out.println("Menu{" + "title='" + title + '}');
    }
}
