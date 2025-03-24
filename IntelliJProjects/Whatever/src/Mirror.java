public class Mirror {
    private int size = 3;

    public static void go(Mirror m, int i) {
        m.size = 9;
        i = 12;
    }

    public static void main(String[] args) {
        int j = 4;
        Mirror m1 = new Mirror();
        Mirror m2 = m1;

        go(m2, j);

        System.out.printf("%d, %d%n", m1.size, j);
    }


}