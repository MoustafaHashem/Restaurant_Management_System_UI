package Human;

import java.time.LocalDate;

public class  Staff extends Person {
    private static int count = 10;
    private final LocalDate joinedDate;
    private final String employeeID;
    private final String email;
    private String password;
    private int salary;
    private String rank;

    public Staff(String name, int age, String address, String phone, String password, int salary, String rank) {
        super(name, age, address, phone);
        this.joinedDate = LocalDate.now();
        this.employeeID = joinedDate.getYear() + Integer.toString(count);
        this.email = employeeID+"@Gusteau.ASU";
        if (checkPassword(password)) this.password = password;
        //Error exception handling
        this.salary = salary;
        this.rank = rank;
        count++;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
        public void print() {
        super.print();
        System.out.println("Employee{employeeID= " + employeeID + ", email= " + email + ", password= " + password + ", salary= " + salary + ", rank= " + rank + "joinedDate"+joinedDate+'}');
    }
    public static boolean checkPassword(String p) {
        return p.length() >= 8;
    }
}
