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
    opens com.httt.server to javafx.fxml;
    exports com.httt.server;
    exports com.httt.server.control.ExamMaker;
    opens com.httt.server.control.ExamMaker to javafx.fxml;
    exports com.httt.server.control.Server;
    opens com.httt.server.control.Server to javafx.fxml;
    exports com.httt.server.control.Server.SerWinPane;
    opens com.httt.server.control.Server.SerWinPane to javafx.fxml;


}