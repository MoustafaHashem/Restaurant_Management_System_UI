package Restaurant;

import Human.Customer;

import Services.Order;
import Services.Reservation;



public class Table {

    private int tableNum;
    private static int count = 1;
    private boolean isReserved;
    protected Order order;
    private Reservation reservation;
    private Customer customer = new Customer();
    public Table() {
        this.tableNum = count++;
        this.isReserved = false;
        this.reservation = new Reservation();
        this.order = new Order();
    }
    public static void setCount(int count) {
        Table.count = count;
    }

    public static int getCount() {
        return count;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }
    public int getTableNum() {
        return tableNum;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public boolean isReserved() {
        return isReserved;
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

}
