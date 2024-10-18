package homework1.my_example.demo4;

import java.io.IOException;

public class MySort extends Filter{
    public MySort(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    protected void transform() throws IOException {
        String[] words = input.readerLine().split(" ");
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
