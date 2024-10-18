package homework1.my_example.demo1;

import homework1.my_example.Ways;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FirstWay extends Ways {

    private String[] words;
    @Override
    public void processWay(String filePath) {
        input(filePath);
        mySort();
        output(filePath);
    }
    public void input(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            words = line.split(" ");
        }catch (Exception e){
            e.printStackTrace();
        }
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
    public void mySort(){
        for(int i = 0; i < words.length - 1; i ++){
            for(int j = i + 1; j < words.length; j ++){
                if(words[j].length() > words[i].length()){
                    String temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                }
            }
        }
    }
}
