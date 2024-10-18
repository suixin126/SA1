package homework1.myFrame;


import homework1.myFrame.example2.Main;

public class SecondWay extends Ways {
    @Override
    public void processWay(String filePath) {
        Main main = new Main();
        main.run(filePath);
    }
}