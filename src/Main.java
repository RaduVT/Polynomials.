public class Main {
    public static void main(String[] args) {
        MyPolinomial m1 = new MyPolinomial(1.1, 2.2, 3.3);
        MyPolinomial m2 = new MyPolinomial(1.1, 2.2, 3.3, 4.4, 5.5);



        System.out.println(m1);
        System.out.println(m1.evaluate(5));
    }
}
