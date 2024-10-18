package homework1.my_example.demo3;

public class SortSubject extends Subject {
    public void startSort(){
        for(int i = 0; i < 4; i ++){
            super.notifyAllObserver(i);
        }
    }
}
