package Restaurant;

public class MenuSection {
    private final String title;
    private final Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public String getTitle() {
        return title;
    }

    public MenuSection(Menu menu, String title) {
        this.title = title;
        this.menu = menu;
    }

    public String printSection() {
        return ("Section: " + title + '\n');
    }

    public String print() {
        return (menu.print() +
                "Section: " + title + '\n');
    }
}
