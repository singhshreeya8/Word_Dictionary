package sample.word_dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Group root; //created a group
    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        stage.setTitle("Word Dictionary");
        DictionaryPage page = new DictionaryPage(); // created object of class having fxml file loaded... page is the child of Group root
        root.getChildren().add(page.root); //added new child "page" to the group
        stage.setScene(new Scene(root, 500, 500)); //rendered the group
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}