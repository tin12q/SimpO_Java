module com.httt.simpo_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires MaterialFX;
    opens com.httt.simpo_java to javafx.fxml;
    exports com.httt.simpo_java;
    exports com.httt.simpo_java.control.ExamMaker;
    opens com.httt.simpo_java.control.ExamMaker to javafx.fxml;
    exports com.httt.simpo_java.control.Server;
    opens com.httt.simpo_java.control.Server to javafx.fxml;
    exports com.httt.simpo_java.control.Server.SerWinPane;
    opens com.httt.simpo_java.control.Server.SerWinPane to javafx.fxml;


}