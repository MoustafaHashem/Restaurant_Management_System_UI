package Services;

import Human.Customer;
import Human.Manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
private  int ID;
private static int count=0;
private LocalDate date;
private int numberOfPeoples;
private final static ArrayList<Reservation> reservations=new ArrayList<>();

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public Reservation(LocalDate date, int numberOfPeoples) {
        this.ID=++count;
        this.date = date;
        this.numberOfPeoples = numberOfPeoples;
    }



    public int getID() {
        return ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public int getNumberOfPeoples() {
        return numberOfPeoples;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNumberOfPeoples(int numberOfPeoples) {
        this.numberOfPeoples = numberOfPeoples;
    }
    public static void cancelReservation(int id){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.remove(i);
        int x = Manager.getTables().size();
        int y;
        for (y = 0; y < x; y++) {
            if (Manager.getTables().get(y).getReservation().getID() == id) {
                Manager.getTables().get(y).removeReservation();
                break;
            }
        }
        System.out.println("cancelled");
    }
    public static void changeReservation(int id,LocalDate d){
        int size = reservations.size(); // if size =0 throw exception
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id){
                break;}
        }
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setNumberOfPeoples(n);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,LocalDate d,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setNumberOfPeoples(n);
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }
    public  static void makeReservation(LocalDate d, int n, int tableNum){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter name");
            String name=in.nextLine();
        System.out.println("Enter age");
            int age=in.nextInt();
        System.out.println("Enter address");
            String address=in.next();
        System.out.println("Enter phone");
            String phone=in.next();
        Customer c=new Customer(name,age,address,phone);
        Reservation r = new Reservation(d,n);
        reservations.add(r);
        System.out.println("reservationID = "+r.getID());
        int size = Manager.getTables().size();
        int i;
        for (i = 0; i < size; i++) {
            if (Manager.getTables().get(i).getTableNum() == tableNum){
                if(Manager.getTables().get(i).isReserved())continue;
                break;}
            // if i =size throw exception handling enter another table
        }
        Manager.getTables().get(i).addReservation(r);
        c.checkIn();
        Manager.getTables().get(i).setCustomer(c);
        System.out.println("reservation done");
    }

    public static String printReservation(int id) {
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id) break;
        }
        if (i == size) return null;
        else return ("Reservation ID: "+reservations.get(i).getID()
                + "\nNumber of people: "+reservations.get(i).getNumberOfPeoples()
                + "\nReservation date: "+ reservations.get(i).getDate()
                +"\n************************************************************\n");
    }


    public static String printReservation() {
        for(Reservation r: reservations) {
            return ("Reservation ID: "+r.getID()
                    + "\nNumber of people: "+r.getNumberOfPeoples()
                    + "\nReservation date: "+ r.getDate()
                    +"\n************************************************************\n");
        }
        return null;
    }
}
