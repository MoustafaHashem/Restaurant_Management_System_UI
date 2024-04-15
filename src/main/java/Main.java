import Human.Manager;
import Human.Staff;
import Restaurant.Menu;
import Restaurant.MenuItem;
import Restaurant.MenuSection;
import Restaurant.Table;
import Services.Bill;
import Services.Order;
import Services.Reservation;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Manager mousatafa=new Manager("Moustafa",20,"El-Obour City","01097963663","123456789",10000,"High");
        Staff kemo=new Staff("kareem",21,"Faisal City","01115393580","555555555",1000,"medium");
        mousatafa.addEmployee(new Staff("micheal",21,"El-Marg City","01229082038","111111111",500,"low"));
        mousatafa.addEmployee(kemo);
        mousatafa.addMenu(new Menu("main menu"));
        mousatafa.addMenuSection(new MenuSection(mousatafa.getMenus().get(0),"Grilled"));
        mousatafa.addMenuSection(new MenuSection(mousatafa.getMenus().get(0),"Fried" ));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(0),"chicken",100));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(0),"meat",150));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(0),"kebab",300));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(1),"fried chicken",150));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(1),"fish",75));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(1),"meat",200));
       for (int i=0;i<5;i++) {
           mousatafa.addTable(new Table());
       }
        for (int i=0;i<5;i++) {
            Manager.getTables().get(i).print();
        }

        System.out.println("---------------------------------------------");
        for (int i=0;i<mousatafa.getEmployees().size();i++) {
            mousatafa.getEmployees().get(i).print();
        }
        mousatafa.removeEmployee("202411");
        for (int i=0;i<mousatafa.getEmployees().size();i++) {
            mousatafa.getEmployees().get(i).print();
        }
        System.out.println("---------------------------------------------");
        for (int i=0;i<mousatafa.getMenus().size();i++) {
            mousatafa.getMenus().get(i).print();
        }
        System.out.println("---------------------------------------------");
        for (int i=0;i<mousatafa.getMenuSections().size();i++) {
            mousatafa.getMenuSections().get(i).print();
        }
        System.out.println("---------------------------------------------");
        for (int i=0;i<mousatafa.getMenuItems().size();i++) {
            mousatafa.getMenuItems().get(i).print();
        }
        System.out.println("---------------------------------------------------------------------------------");
            Reservation.makeReservation(LocalDate.now(),1,1);
            Order.addOrder(1);
            Bill.payment(1);
        System.out.println("hey");
    }
}
