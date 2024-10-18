package homework1.my_example.demo3;


import homework1.my_example.demo3.Observer;

import java.util.LinkedList;
import java.util.List;

public class Subject {
    //观察者数组
    private static List<Observer> vector = new LinkedList<>();


    //增加一个观察者
    public static void addObserver(Observer observer) {
        vector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {

        vector.remove(observer);
    }

    //通知所有观察者
    public void notifyAllObserver(int i) {

        for(Observer observer : vector) {

            observer.toDo();
        }
    }

    // 通知特定观察者
    public void notifyOneObserver(int i) {
        vector.get(i).toDo();
    }
}
