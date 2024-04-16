module org.example.restaurant_management_system_ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.example.restaurant_management_system_ui to javafx.fxml;
    exports org.example.restaurant_management_system_ui;
    exports org.example.restaurant_management_system_ui.staff;
    opens org.example.restaurant_management_system_ui.staff to javafx.fxml;
    exports org.example.restaurant_management_system_ui.customer;
    opens org.example.restaurant_management_system_ui.customer to javafx.fxml;
}