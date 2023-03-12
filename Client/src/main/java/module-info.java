module com.httt.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    requires MaterialFX;
    requires ea.async;


    opens com.httt.client to javafx.fxml;
    exports com.httt.client;
    opens com.httt.client.control to javafx.fxml;
    exports com.httt.client.control;
    opens com.httt.client.control.clientWin to javafx.fxml;
    exports com.httt.client.control.clientWin;
    opens com.httt.client.control.mcWin to javafx.fxml;
    exports com.httt.client.control.mcWin;
    opens com.httt.client.control.viewerWin to javafx.fxml;
    exports com.httt.client.control.viewerWin;
    opens com.httt.client.control.diemWin to javafx.fxml;
    exports com.httt.client.control.diemWin;
    opens com.httt.client.control.clientWin.clientPane to javafx.fxml;
    exports com.httt.client.control.clientWin.clientPane;
    opens com.httt.client.control.clientWin.Pane to javafx.fxml;
    exports com.httt.client.control.clientWin.Pane;
}