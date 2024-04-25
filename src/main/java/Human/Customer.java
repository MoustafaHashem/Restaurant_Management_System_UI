package Human;

import java.time.LocalDate;

public class Customer extends Person {
    private static int count = 1;
    private  int customerId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Customer() {
super();
    }

    public Customer(String name, int age, String address, String phone) {
        super(name, age, address, phone);
        this.customerId = count++;
    }
    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String print() {
        super.print();
        return ( " customerId= " + customerId );
    }

    public void checkIn() {
        checkInDate = LocalDate.now();
    }

    public void checkOut() {
        checkOutDate = LocalDate.now();
    }
}
