module co.edu.poli.examen2_sanabria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens co.edu.poli.examen2_sanabria.controlador to javafx.fxml;
    opens co.edu.poli.examen2_sanabria.vista to javafx.graphics, javafx.fxml;

    exports co.edu.poli.examen2_sanabria.vista;
    exports co.edu.poli.examen2_sanabria.modelo;
    exports co.edu.poli.examen2_sanabria.controlador;
    exports co.edu.poli.examen2_sanabria.servicios;
}