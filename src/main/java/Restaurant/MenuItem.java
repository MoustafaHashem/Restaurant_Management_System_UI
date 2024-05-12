package Restaurant;

import java.util.Arrays;


import static Restaurant.Restaurant.menuItems;

public class MenuItem implements Comparable {
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

    public static void sortMenuItems() {
        MenuItem[] arrMenuItems = new MenuItem[menuItems.size()];
        menuItems.toArray(arrMenuItems);
        Arrays.sort(arrMenuItems);
        menuItems.clear();
        menuItems.addAll(Arrays.asList(arrMenuItems));
    }

    @Override
    public int compareTo(Object m) {
        int returnValue = 0;
//Version1: sorting alphabetically
//            if (this.getTitle().compareTo(((MenuItem) m).getTitle()) > 0) {
//                returnValue = 1;
//            } else if (this.getTitle().compareTo(((MenuItem) m).getTitle()) < 0) {
//                returnValue = -1;
//            }
//        }

//Version2: sorting by price
            if (this.getPrice() > ((MenuItem) m).getPrice()) {
                returnValue = 1;
            } else if (this.getPrice() < ((MenuItem) m).getPrice()) {
                returnValue = -1;
            }
//        }
        return returnValue;
    }


    public MenuSection getMenuSection() {
        return menuSection;
    }

    public int getID() {
        return ID;
    }

    public String printItem() {
        return ("Item: " + title + " , ID: " + ID + " , Price: " + price + '\n');
    }

    public String print() {
        return (menuSection.print() +
                "Item: " + title + " , ID: " + ID + " , Price: " + price + '\n');
    }
}
