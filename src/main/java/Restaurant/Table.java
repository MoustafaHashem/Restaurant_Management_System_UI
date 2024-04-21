package Restaurant;

import Human.Customer;
import Services.Order;
import Services.Reservation;

public class Table {

    private final int tableNum;
    private static int count = 1;
    private boolean isReserved;
    protected Order order;
    private Reservation reservation;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Table(){
        this.tableNum = count++;
        this.isReserved = false;
        this.reservation = new Reservation();
        this.order = new Order();
        this.customer = new Customer();
    }

    public int getTableNum() {
        return tableNum;
    }
    public boolean isReserved(){
        return isReserved;
    }

    public Order getOrder() {
        return order;
    }

    public Reservation getReservation() {
        return reservation;
    }
    public void removeReservation() {
          this.reservation=null;
          this.isReserved=false;
          this.order=null;
          this.customer=null;
    }

    public void addReservation (Reservation reservation){
        this.reservation = reservation;
        isReserved = true;
    }
    public void addOrder (Order order){
        this.order = order;
    }
    public String print() {
        return ( "Table number : " + tableNum + " , Is Reserved ? " + isReserved + '\n');
    }

}
