package Services;

import Human.Customer;
import Human.Manager;
import Restaurant.Table;


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
    public static void cancelReservation(){
        Scanner input= new Scanner(System.in);
        int size = reservations.size();
        int i;
        boolean invalidReservation = true;

        do {
            System.out.println("Enter ID of Reservation to be cancelled: ");
            int id= input.nextInt();
            for (i = 0; i < size; i++) {
                if (reservations.get(i).getReservationId() == id)
                {
                    invalidReservation=false;
                }
                if(!invalidReservation)
                {
                    for (Table table: Manager.getTables()) {
                        if (table.getReservation().getReservationId() == id) {
                            table.removeReservation();
                            break;
                        }
                    }
                    reservations.remove(i);
                    System.out.println("Reservation cancelled");
                    System.out.println("************************************************************");
                    break;
                }
                else {
                    System.out.println("Entered Reservation ID not valid");
                    System.out.println("************************************************************");
                }
            }
        }while(invalidReservation);
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
    public static void makeReservation(String name , int age,String address ,String phone,LocalDate date, int numberOfPeople){
        Reservation r;
        int i;
        int selectedTable;
        boolean invalidTable=true;

        }
        if (!availableTables.isEmpty())
        {
            Customer c = new Customer(name,age,address,phone);
            r = new Reservation(date,numberOfPeople);
            reservations.add(r);
            for(Table table:availableTables)
            {
                System.out.println("Table "+ table.getTableNum());
            }
            do {
                System.out.println("\nWhich table do you want to make your reservation?");
                selectedTable = in.nextInt();
                for (Table table:availableTables) {
                    if (table.getTableNum() == selectedTable) {
                        invalidTable = false;
                        break;
                    }
                }
                if(!invalidTable)
                {
                    Manager.getTables().get(selectedTable-1).addReservation(r);
                    c.checkIn();
                    Manager.getTables().get(selectedTable-1).setCustomer(c);
                    Manager.getTables().get(selectedTable-1).setIsReserved(true);
                    System.out.println("Reservation done successfully");
                    System.out.println("Your Reservation ID is: "+ r.getReservationId());
                    System.out.println("************************************************************");
                }
                else {
                    System.out.println("Please enter a valid table number from the available tables listed above");
                }
            }while(invalidTable);

        }
        else
        {
            System.out.println("No available tables for making a reservation at the restaurant at the moment");
            System.out.println("************************************************************");
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
