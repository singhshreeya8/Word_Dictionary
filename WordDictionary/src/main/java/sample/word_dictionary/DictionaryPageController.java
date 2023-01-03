package sample.word_dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Locale;

public class DictionaryPageController {

    private DictionarySaver db;
    @FXML
    TextField search;
    @FXML
    TextField newword;
    @FXML
    TextField meaning;
    @FXML
    TextField findword;

    @FXML
    public void searchButton(MouseEvent event) throws ClassNotFoundException {
       try {
           db = new DictionarySaver();
           db.deserializeHashMap();

           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText("Dictionary");

           if(search.getText().equals("")){
               alert.setContentText("Please enter a word to search");
               alert.showAndWait();
           }
           else if (db.getDictionaryList().containsKey(search.getText().toLowerCase())) {
               alert.setContentText("The word is AVAILABLE in the dictionary");
               alert.showAndWait();
           }
           else {
               alert.setContentText("The word is NOT AVAILABLE in the dictionary");
               alert.showAndWait();
           }
       }
       catch(IOException ex){
           db.serializeHashMap();
           System.out.println("Exception Resolved");
       }
    }

    @FXML
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap(); //pulls back all existing n words

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");

        if(newword.getText().equals("") || meaning.getText().equals("")){
            alert.setContentText("Please enter a word/meaning to add in the dictionary!");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(newword.getText().toLowerCase())){
            alert.setContentText("The word is already available in the dictionary!");
            alert.showAndWait();
        }
        else{
            db.getDictionaryList().put(newword.getText().toLowerCase(),meaning.getText()); //adding new word
            db.serializeHashMap();//putting n+1 words back
            alert.setContentText("New Word is added to the Dictionary");
            alert.showAndWait();
        }


    }

    @FXML
    public void Meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Meaning");

        if(findword.getText().equals("")){
            alert.setContentText("Please enter a word to find its meaning.");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(findword.getText().toLowerCase())){
            alert.setContentText(db.getDictionaryList().get(findword.getText().toLowerCase()));
            alert.showAndWait();
        }
        else{
            alert.setContentText("The word is not available in the dictionary");
            alert.showAndWait();
        }

    }

}
