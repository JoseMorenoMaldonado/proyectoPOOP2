module com.mycompany.proyectopoo2p {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectopoo2p to javafx.fxml;
    exports com.mycompany.proyectopoo2p;
}
