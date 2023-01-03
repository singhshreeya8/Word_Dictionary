module sample.word_dictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.word_dictionary to javafx.fxml;
    exports sample.word_dictionary;
}