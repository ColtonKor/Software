public class B extends A {
    public String methodB() {
        String result = String.format("The result is %s.%n", methodA());
        return result;
    }
}
