import java.util.ArrayList;

public class Dynamic implements Queueable{
    private ArrayList<Character> queue = new ArrayList<Character>();
    private static int index = 0;
    @Override
    public void put(char ch) {
        queue.add(ch);
    }

    @Override
    public char get() {
        if(queue.isEmpty()){
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return queue.get(index++);
    }
}
