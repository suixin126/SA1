package homework1.my_example.demo4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Input extends Filter{

    private File file;
    public Input(File file, Pipe output) {
        super(null, output);
        this.file = file;
    }

    @Override
    protected void transform() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            output.writerLine(line);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
