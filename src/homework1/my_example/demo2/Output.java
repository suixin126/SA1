package homework1.my_example.demo2;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Output {
    private String[] words;

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public Output(String[] words){
        this.words = words;
    }

    public void output(String fileName){
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