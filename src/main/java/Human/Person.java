package Human;

public class Person {
    private String name = "noName";
    private int age;
    private String address;
    private String phone;

    public Person(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }



    public String print() {
        return ("name= " + name + "\n age= " + age + "\n address= " + address + "\n phone= " + phone);
    }
}
