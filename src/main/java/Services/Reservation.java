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
    private  static final ArrayList<Reservation> reservations=new ArrayList<>();
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
        int i;
        for (i = 0; i < Manager.getTables().size(); i++) { if (Manager.getTables().get(i).getTableNum() == tableID){
            break;}}
        reservations.remove(Manager.getTables().get(i).getReservation());
        Table t=new Table();
        t.setTableNum(tableID);
        Table.setCount(Table.getCount()-1);
        Manager.getAvailableTables().add(tableID-1,t);
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
//        System.out.println("Number of people and date changed");
    }
    public static int makeReservation(int tableToBeReserved,String name , int age,String address ,String phone,LocalDate date, int numberOfPeople){

        Reservation r;

        if (!(Manager.getAvailableTables().isEmpty())) {
            Customer c = new Customer(name, age, address, phone);
            r = new Reservation(date, numberOfPeople);
            reservations.add(r);
            Manager.getTables().get(tableToBeReserved - 1).addReservation(r);
            c.checkIn();
            Manager.getTables().get(tableToBeReserved - 1).setCustomer(c);
            int i;
            for (i = 0; i < Manager.getTables().size(); i++) { if (Manager.getTables().get(i).getTableNum() == tableToBeReserved){
                break;}}

            Manager.getAvailableTables().remove(Manager.getTables().get(i));

            return 1;
        }
        else
        {
            return -1;
        }
    }
}