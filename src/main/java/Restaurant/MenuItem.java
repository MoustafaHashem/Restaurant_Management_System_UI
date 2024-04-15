package Restaurant;

public class MenuItem {
    private final String title;
    private final int ID;
    private static int count;
    private double price;
    private final MenuSection menuSection;

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuItem(MenuSection menuSection, String title, double price) {
        this.title = title;
        this.ID = count++;
        this.price = price;
        this.menuSection = menuSection;
    }
    public void updatePrice(double p){
        setPrice(p);
    }

    public MenuSection getMenuItem() {
        return menuSection;
    }

    public int getID() {
        return ID;
    }
    public void print() {
        menuSection.print();
        System.out.println("MenuItem{" + "title= " + title + ", ID= " + ID + ", price= " + price + '}');
    }
}
