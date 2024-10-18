package homework1.myFrame.example2;

public class Main {

    public void run(String fileName) {

        Input input = new Input();
        input.input(fileName);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output(fileName);

    }
}
