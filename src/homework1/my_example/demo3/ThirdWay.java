package homework1.my_example.demo3;

import homework1.my_example.Ways;

public class ThirdWay extends Ways {
    @Override
    public void processWay(String filePath) {
        //创建主题
        SortSubject kwicSubject = new SortSubject();
        //创建观察者
        ThirdInput input = new ThirdInput(filePath);
        ThirdMySort mySort = new ThirdMySort(input.getWords());
        ThirdOutput output = new ThirdOutput(mySort.getWords(), filePath);

        // 将观察者加入主题
        SortSubject.addObserver(input);
        SortSubject.addObserver(mySort);
        SortSubject.addObserver(output);
        // 逐步调用各个观察者
        kwicSubject.startSort();
    }
}
