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

    public Staff(String name, int age, String address, String phone, int salary, String rank) {
        super(name, age, address, phone);
        this.joinedDate = LocalDate.now();
        this.employeeID = joinedDate.getYear() + Integer.toString(count);
        this.email = employeeID+"@Gusteau.ASU";
         this.password = employeeID;
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
        if (checkPassword(password))this.password = password;
       // else "exception handling";
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }// for manger only

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }// for manger only

    @Override
        public void print() {
        super.print();
        System.out.println("Employee{employeeID= " + employeeID + ", email= " + email + ", password= " + password + ", salary= " + salary + ", rank= " + rank + "joinedDate"+joinedDate+'}');
    }
    public static boolean checkPassword(String p) {
        return p.length() >= 8;
    }
}
