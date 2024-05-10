package Services;

import Human.Manager;
import Restaurant.MenuItem;
import Restaurant.Table;

import java.util.ArrayList;


public class Order {
    private double cost = 0;
    private final ArrayList<MenuItem> meals = new ArrayList<>();


    public double getCost() {
        return cost;
    }

    public Order() {
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public ArrayList<MenuItem> getMeals() {
        return meals;
    }


    public static MenuItem addMeal(int ID) {
        //  System.out.println("search for meal");
        int size = Manager.getMenuItems().size();
        int i;
        for (i = 0; i < size; i++) {
            //   System.out.println("chek id ");
            if (Manager.getMenuItems().get(i).getID() == ID)
                break;
        }
        // System.out.println("chek 1 ");
        return Manager.getMenuItems().get(i);

    }







    public static String printOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();
        int i;
        int size1 = Manager.getTables().size();
        for (i = 0; i < size1; i++) {
            if (Manager.getTables().get(i).getOrder().getCost() != 0) {
                orders.add(Manager.getTables().get(i).getOrder());
                z.add(i);
            }
        }
        int size2 = orders.size();
        StringBuilder s = new StringBuilder();

        for (int j = 0; j < size2; j++) {
            s.append("Order -> table #").append(Manager.getTables().get(z.get(j)).getTableNum()).append("\nMeals : ");
            for (int k = 0; k < orders.get(j).meals.size(); k++) {
                s.append(orders.get(j).meals.get(k).print());
            }
            s.append("\nTotal Cost: ").append(orders.get(j).getCost()).append("\n************************************************************\n");
        }
        return String.valueOf(s);
    }

    public static String print(Table t) {
        StringBuilder s = new StringBuilder();
        s.append("Order -> table #").append(t.getTableNum()).append("\nMeals : ");
        for (int i = 0; i < t.getOrder().meals.size(); i++) {
            s.append(t.getOrder().meals.get(i).print());
        }
        s.append("\nTotal Cost: ").append(t.getOrder().getCost()).append("\n************************************************************\n");
        return String.valueOf(s);
    }

    public String print() {
        StringBuilder s = new StringBuilder();
        s.append("Order").append("\nMeals : ");
        for (int i = 0; i < this.meals.size(); i++) {
            s.append(this.meals.get(i).print());
        }
        s.append("Cost: ").append(this.getCost());
        return String.valueOf(s);
    }
}
