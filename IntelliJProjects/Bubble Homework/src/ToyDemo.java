public class ToyDemo {
    public static void main(String[] args) {
        ToyClass obj1 = new ToyClass("South Dakota", 57049);
        ToyClass obj2;
        obj2 = obj1;
        obj2.set("North Dakota", 58047);
        System.out.println(obj1);
    }
}
