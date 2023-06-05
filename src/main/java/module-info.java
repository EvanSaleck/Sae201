module fr.beastsheep.jeusociete {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.beastsheep.jeusociete to javafx.fxml;
    exports fr.beastsheep.jeusociete;
}