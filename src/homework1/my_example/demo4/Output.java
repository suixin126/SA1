package homework1.my_example.demo4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output extends Filter{
    private File file;
    public Output(File file, Pipe input) {
        super(null,input);
        this.file = file;
    }

    @Override
    protected void transform() throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,false))) {
            String[] words = input.readerLine().split(" ");
            for(int i = 0; i < words.length; i ++){
                String word = words[i];
                bw.write(word + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
