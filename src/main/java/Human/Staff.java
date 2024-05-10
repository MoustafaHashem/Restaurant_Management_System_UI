package Human;

import java.time.LocalDate;

public class Staff extends Person {
    private static int count = 10;
    private LocalDate joinedDate;
    private String employeeID;
    private String email;
    private String password;
    private int salary;
    private String rank;

    public Staff(String name, int age, String address, String phone, int salary, String rank) {
        super(name, age, address, phone);
        this.joinedDate = LocalDate.now();
        this.employeeID = joinedDate.getYear() + Integer.toString(count);
        this.email = employeeID + "@Gusteau.ASU";
        this.password = employeeID;
        this.salary = salary;
        this.rank = rank;
        count++;
    }

    public Staff() {
        super();
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
        if (checkPassword(password)) this.password = password;
        // else "exception handling";
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }// for manger only


    public void setRank(String rank) {
        this.rank = rank;
    }// for manger only

    @Override
    public String print() {
        return super.print()
                +
                ("\nemployeeID= " + employeeID + "\n email= " + email + "\n password= " + password + "\n salary= " + salary + "\n rank= " + rank + "\njoinedDate" + joinedDate);
    }

    public static boolean checkPassword(String p) {
        return p.length() >= 8;
    }
}
