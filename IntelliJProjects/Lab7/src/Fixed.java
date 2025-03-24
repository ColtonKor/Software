public class Fixed implements Queueable {
    private char[] queue;
    private int putLoc;
    private int getLoc;
    public Fixed(int size) {
        queue = new char[size];
        putLoc = getLoc = 0;
    }
    public void put(char ch) {
        if (putLoc == queue.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        queue[putLoc++] = ch;
    }
    public char get() {
        if (getLoc == putLoc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return queue[getLoc++];
    }
}
