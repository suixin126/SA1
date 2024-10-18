package homework1.my_example.demo4;

import homework1.my_example.Ways;

import java.io.File;
import java.io.IOException;

public class FourthWay extends Ways {
    @Override
    public void processWay(String filePath){
        File inFile = new File(filePath);
        File outFile = new File(filePath);
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        MySort shift = new MySort(pipe1, pipe2);
        Output output = new Output(outFile,pipe3);
        try {
            input.transform();
            shift.transform();
            output.transform();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
