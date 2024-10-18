package homework1.example2;

public class Main {

    public static void main(String[] args) {

        Input input = new Input();
        input.input("C:\\houduanstudy\\java\\SA\\untitled\\resource\\input2.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("C:\\houduanstudy\\java\\SA\\untitled\\resource\\input2.txt");

    }
}
