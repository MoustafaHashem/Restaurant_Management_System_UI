package Human;

import java.time.LocalDate;

public class Customer extends Person {
    private static int count = 1;
    private int customerId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Customer() {
        super();
    }

    public Customer(String name, int age, String address, String phone) {
        super(name, age, address, phone);
        this.customerId = count++;
    }



    @Override
    public String print() {
        super.print();
        return (" customerId= " + customerId);
    }

    public void checkIn() {
        this.checkInDate = LocalDate.now();
    }

    public void checkOut() {
        this.checkOutDate = LocalDate.now();
    }
}
