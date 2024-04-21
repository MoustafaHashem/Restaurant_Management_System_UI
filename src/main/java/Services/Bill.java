package Services;


import Human.Manager;
import Restaurant.Table;

import java.util.Scanner;

public abstract class Bill extends Table {

    static String[] promocodes= {"BVC876JH","SER245TK","EGH854QA","ZWP725BB","HGH888LL"};

    public static double payment(int tableNum, String promo){

        boolean flag = false;
        int x = Manager.getTables().size();
        int y;

        for (y = 0; y < x; y++) {
                    if (tableNum == Manager.getTables().get(y).getTableNum()) {
                        flag = true;
                        break;
                    }
        }
        double cost = Manager.getTables().get(y).getOrder().getCost();
        for (String promocode : promocodes) {
            if (promo.equals(promocode)) cost = cost*0.75;
            break;
        }


       // System.out.println(" you should pay " +Manager.getTables().get(y).getOrder().getCost()+"after discount "/*+(Manager.getTables().get(y).getOrder().getCost()-Manager.getTables().get(y).getCustomer().getDiscount())*/);


        Manager.getTables().get(y).getCustomer().checkOut();
        Manager.getTables().get(y).removeReservation();

        return cost ;
    }



}
