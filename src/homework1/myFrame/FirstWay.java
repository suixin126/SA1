package homework1.myFrame;

import homework1.myFrame.example1.Demo1;


public class FirstWay extends Ways{

    @Override
    public void processWay(String filePath) {
        Demo1 demo1 = new Demo1();
        demo1.run(filePath);
    }
}
