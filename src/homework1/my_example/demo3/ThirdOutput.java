package homework1.my_example.demo3;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ThirdOutput implements Observer {
    private String[] words;
    private String fileName;

    public String[] getWords() {
        return words;
    }

    public ThirdOutput(String[] words,String fileName){
        this.words = words;
        this.fileName = fileName;
    }

    @Override
    public void toDo() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,false))) {
            for(int i = 0; i < words.length; i ++){
                String word = words[i];
                bw.write(word + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
