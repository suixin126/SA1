package homework1.my_example.demo2;

import homework1.my_example.Ways;
import homework1.my_example.demo2.Input;
import homework1.my_example.demo2.MySort;
import homework1.my_example.demo2.Output;

public class SecondWay extends Ways {
    @Override
    public void processWay(String filePath) {
        Input input = new Input();
        input.input(filePath);
        MySort mySort = new MySort(input.getWords());
        mySort.mySort();
        Output output = new Output(mySort.getWords());
        output.output(filePath);
    }
}
