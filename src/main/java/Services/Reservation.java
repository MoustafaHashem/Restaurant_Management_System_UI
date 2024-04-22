package Services;

import Human.Customer;
import Human.Manager;
import Restaurant.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Reservation {
    private  int reservationId;
    private static int count=0;
    private LocalDate date;
    private int numberOfPeople;
    private  static ArrayList<Reservation> reservations=new ArrayList<>();

    public Reservation() {
    }

    public Reservation(LocalDate date, int numberOfPeople) {
        this.reservationId=++count;
        this.date = date;
        this.numberOfPeople = numberOfPeople;
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public int getReservationId() {
        return reservationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setID(int ID) {
        this.reservationId = ID;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
    public static void cancelReservation(int tableID){
        reservations.remove(tableID-1);
        Manager.getAvailableTables().get(tableID-1).setIsReserved(false);
        Manager.getAvailableTables().remove(tableID-1);

    }
    public static void changeReservation(int id,LocalDate d){
        int size = reservations.size(); // if size =0 throw exception
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getReservationId() == id){
                break;}
        }
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getReservationId() == id)
                break;
        }
        reservations.get(i).setNumberOfPeople(n);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,LocalDate d,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getReservationId() == id)
                break;
        }
        reservations.get(i).setNumberOfPeople(n);
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }
    public static int makeReservation(int tableToBeReserved,String name , int age,String address ,String phone,LocalDate date, int numberOfPeople){
        Reservation r;
        ArrayList<Table>availableTables;
        Table t;
        availableTables=Manager.getAvailableTables();
        if (!availableTables.isEmpty()) {
            Customer c = new Customer(name, age, address, phone);
            r = new Reservation(date, numberOfPeople);
            t= new Table(tableToBeReserved,true,r);
            reservations.add(r);
            Manager.getTables().get(tableToBeReserved - 1).addReservation(r);
            c.checkIn();
            Manager.getTables().get(tableToBeReserved - 1).setCustomer(c);
            Manager.getTables().get(tableToBeReserved - 1).setIsReserved(true);
            Manager.getAvailableTables().add(t);
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public static String printReservation()
    {
        String accumulator="";
        for(Reservation r: reservations)
        {
           accumulator= "Reservation ID: "+r.getReservationId()
           +"Number of people: "+r.getNumberOfPeople()
           +"Reservation date: "+ r.getDate()
            +"************************************************************"
            +"\n";
        }
        return accumulator;
    }
}
