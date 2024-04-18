package Human;

import Restaurant.*;

import java.util.ArrayList;

public class Manager extends Staff implements Restaurant {
    public Manager() {
        super();
    }

    public Manager(String name, int age, String address, String phone, int salary, String rank ) {
        super(name, age, address, phone, salary, rank);
    }
    @Override
    public void addMenu(Menu m){getMenus().add(m);}

    @Override
    public void addMenuSection(MenuSection ms){
        getMenuSections().add(ms);
    }

    @Override
    public void addMenuItem(MenuItem mi){
        getMenuItems().add(mi);
    }

    @Override
    public void addTable(Table t){
        getTables().add(t);
    }

    @Override
    public void addEmployee(Staff e){
        getEmployees().add(e);
    }

    @Override
    public void removeEmployee(String id){
        int size = getEmployees().size();
        int i;
        for (i = 0; i < size; i++) {
            if (0 == getEmployees().get(i).getEmployeeID().compareTo(id))
                break;
        }
        // if i = size exception handling
        getEmployees().remove(i);
    }

    public static ArrayList<Staff> getEmployees() {
        return employees;
    }
    public static ArrayList<Table> getTables() {
        return tables;
    }
    public static ArrayList<Menu> getMenus() {
        return menus;
    }
    public static ArrayList<MenuSection> getMenuSections() {
        return menuSections;
    }
    public static ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
