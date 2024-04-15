package Services;


import Human.Manager;
import Restaurant.Table;

import java.util.Scanner;

public abstract class Bill extends Table {

    public static void payment(int tableNum){
        int x = Manager.getTables().size();
        int y;
        for (y = 0; y < x; y++) {
            if (tableNum == Manager.getTables().get(y).getTableNum()) break;
        }
        System.out.println("\ni wish our food is delicious now time for paying :) \n"+"for cash press 1\nfor visa press2");
        Scanner in=new Scanner(System.in);
        int typeOfPay = in.nextInt();
        System.out.println(" you should pay " +Manager.getTables().get(y).getOrder().getCost()+"after discount "/*+(Manager.getTables().get(y).getOrder().getCost()-Manager.getTables().get(y).getCustomer().getDiscount())*/);
        if (typeOfPay ==1) System.out.println("enter money");
        else if (typeOfPay ==2){
            Scanner scan = new Scanner(System.in);
            System.out.println("enter password");
            int password = scan.nextInt();
            visa(password);
        }
        else{ //exception handling
            System.out.println("invalid payment method");
        }
        Manager.getTables().get(y).getCustomer().checkOut();
        System.out.println("Thank You For Coming Our Restaurant");
        Manager.getTables().get(y).removeReservation();
    }

    public static void visa (int password){
        System.out.println("the debited done ");
    }

}
