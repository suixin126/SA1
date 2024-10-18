package homework1.my_example.demo3;

import java.io.BufferedReader;
import java.io.FileReader;

public class ThirdInput implements Observer {
    private String[] words;
    private String fileName;
    public String[] getWords() {
        return words;
    }
    public ThirdInput(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void toDo() {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            words = line.split(" ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
