package homework1.myFrame;

import homework1.myFrame.example4.Main;

import java.io.IOException;

public class FourthWay extends Ways{
    @Override
    public void processWay(String filePath) {
        Main main = new Main();
        try {
            main.run(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
