package Restaurant;

import Human.Customer;
import Human.Manager;
import Services.Order;
import Services.Reservation;

import java.util.ArrayList;

public class Table {

    private int tableNum;
    private static int count = 1;
    private boolean isReserved;
    protected Order order;
    private Reservation reservation;
    private Customer customer = new Customer();

    public static void setCount(int count) {
        Table.count = count;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public static int getCount() {
        return count;
    }


    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Table() {
        this.tableNum = count++;
        this.isReserved = false;
        this.reservation = new Reservation();
        this.order = new Order();
    }

    public Table(int tableNum, boolean isReserved, Reservation reservation) {
        this.tableNum = count++;
        this.isReserved = false;
        this.reservation = new Reservation();
    }

    public void setTable(Table table) {
        for (int i = 0; i < Manager.getTables().size(); i++) {
            if (table.getTableNum() == this.getTableNum()) {
                this.isReserved = false;
                this.reservation = table.getReservation();
                this.customer = table.getCustomer();
            }
        }
    }

    public int getTableNum() {
        return tableNum;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public Order getOrder() {
        return order;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void removeReservation() {
        this.reservation = null;
        this.isReserved = false;
        this.order = null;
        this.customer = null;
    }

    public void addReservation(Reservation reservation) {
        this.reservation = reservation;
        isReserved = true;
    }

    public void addOrder(Order order) {
        this.order = order;
    }

    public String print() {
        return ("Table number : " + tableNum + " , Is Reserved ? " + isReserved + '\n');
    }

    public void setIsReserved(boolean b) {
        this.isReserved = b;
    }
}
