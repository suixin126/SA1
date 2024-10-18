package homework1.my_example.demo2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Input {

    private String[] words;
    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
    public void input(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            words = line.split(" ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}