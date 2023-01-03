package sample.word_dictionary;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {
    private HashMap<String, String> dictionaryList;
    DictionarySaver(){
        dictionaryList = new HashMap<>();
    }

    HashMap<String,String> getDictionaryList(){
        return dictionaryList;
    }
    void serializeHashMap(){
        try{
            FileOutputStream fos = new FileOutputStream("dictionaryData"); //outputting hashmap in a file
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dictionaryList); //output our hashmap to the output stream
            oos.close();
            fos.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    void deserializeHashMap() throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream("dictionaryData"); //outputting hashmap in a file
        ObjectInputStream ois = new ObjectInputStream(file);

        dictionaryList = (HashMap<String, String>) ois.readObject();



    }

}
