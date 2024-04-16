package Restaurant;

import Human.Staff;

import java.util.ArrayList;

public interface Restaurant {
      String NAME="Gusteau";
      String LOCATION="France";
      int STARS=5;
     ArrayList<Staff> employees=new ArrayList<>();
     ArrayList<Table> tables=new ArrayList<>();
     ArrayList<Menu> menus=new ArrayList<>();
     ArrayList<MenuSection> menuSections=new ArrayList<>();
     ArrayList<MenuItem> menuItems=new ArrayList<>();
     void addMenu(Menu m);
     void addMenuSection(MenuSection ms);
     void addMenuItem(MenuItem mi);
     void addTable(Table t);
     void addEmployee(Staff e);
     void removeEmployee(String id);
}
