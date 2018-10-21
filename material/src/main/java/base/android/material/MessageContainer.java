package base.android.material;

import java.util.ArrayList;

public class MessageContainer {
    private ArrayList<String> messages = new ArrayList<>();
    public void add(String text){
        messages.add(text);
    }
    public String get(int index){
        return messages.get(index);
    }
    public int len(){
        return messages.size();
    }

}
