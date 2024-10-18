package homework1.my_example.demo2;

public class MySort {


    private String[] words;
    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
    public MySort(String[] words){
        this.words = words;
    }
    public void mySort(){
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
