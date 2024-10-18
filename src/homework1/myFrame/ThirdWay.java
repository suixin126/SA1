package homework1.myFrame;

import homework1.myFrame.example3.Main;

public class ThirdWay extends Ways{
    @Override
    public void processWay(String filePath) {
        Main main = new Main();
        main.run(filePath);
    }
}
