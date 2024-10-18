package homework1.example3;

public class KWICSubject extends Subject{

    public void startKWIC(){

        for (int i = 0;i <= 3;i++){

            super.notifyOneObserver(i);

        }
    }
}
