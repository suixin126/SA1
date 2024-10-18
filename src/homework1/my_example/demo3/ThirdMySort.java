package homework1.my_example.demo3;

public class ThirdMySort implements Observer {
    private String[] words;
    public String[] getWords() {
        return words;
    }
    public ThirdMySort(String[] words){
        this.words = words;
    }
    @Override
    public void toDo() {
        for(int i = 0; i < words.length - 1; i ++){
            for(int j = i + 1; j < words.length; j ++){
                if(words[j].length() > words[i].length()){
                    String temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                }
            }
        }
    }
}
