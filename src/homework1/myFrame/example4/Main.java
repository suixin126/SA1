package homework1.myFrame.example4;

import java.io.File;
import java.io.IOException;

public class Main {

    public void run(String fileName) throws IOException {

        File inFile = new File(fileName);
        File outFile = new File(fileName);
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}
