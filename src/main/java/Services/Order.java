package Services;

import Human.Manager;
import Restaurant.MenuItem;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private double cost=0;
    private final ArrayList<MenuItem> meals=new ArrayList<>();

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }



    public  ArrayList<MenuItem> getMeals() {
        return meals;
    }




    public static MenuItem addMeal(int ID){
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
    public static MenuItem removeMeal(int ID){
        int size = Manager.getMenuItems().size();
        int i;
        for (i = 0; i < size; i++) {
            if (Manager.getMenuItems().get(i).getID() == ID)
                break;
        }
        return Manager.getMenuItems().get(i);

    }

    public static void addOrder(int tableNum) throws InterruptedException { // edit func to take int
        Order order=new Order();
        //System.out.println("check 1");
        int x = Manager.getTables().size();
       // System.out.println("check 2");
        int y;
        for (y = 0; y < x; y++) {
          //  System.out.println("check 3"+Manager.getTables().get(y).getTableNum());
            if (tableNum == Manager.getTables().get(y).getTableNum()) break;
        }
       // System.out.println("find table");
        int num = Manager.getTables().get(y).getReservation().getNumberOfPeoples();
        int i;
        for (i = 1; i <= num; i++) {
        System.out.println(i +"# order");
        Scanner in = new Scanner(System.in);
            System.out.println("enter id for meal");
            MenuItem mi=addMeal(in.nextInt());
           order.meals.add(mi);
            order.setCost(order.getCost()+mi.getPrice());
            System.out.println("meal added");
        }
        System.out.println("order is cooking");

        // add order to table
        Manager.getTables().get(y).addOrder(order);
        Thread.sleep(10000);
        System.out.println("order is cooked");
    }
    public static void modifyOrder(int tableNum, int oldMeal, int newMeal) { // edit func to take int
        int x = Manager.getTables().size();
        int y;
        for (y = 0; y < x; y++) {
            if (tableNum == Manager.getTables().get(y).getTableNum()) break;
        }
        int num = Manager.getTables().get(y).getReservation().getNumberOfPeoples();
        int i;
        for (i = 1; i <= num; i++) {
            if (oldMeal == Manager.getTables().get(y).getOrder().getMeals().get(i).getID()) {
                break;
            }
        }
        Manager.getTables().get(y).getOrder().setCost(Manager.getTables().get(y).getOrder().getCost()-Manager.getTables().get(y).getOrder().getMeals().get(i).getPrice());
        Manager.getTables().get(y).getOrder().getMeals().remove(i);
        MenuItem mi=addMeal(newMeal);
        Manager.getTables().get(y).getOrder().getMeals().add(mi);
        Manager.getTables().get(y).getOrder().setCost(Manager.getTables().get(y).getOrder().getCost()+mi.getPrice());
    }
}
