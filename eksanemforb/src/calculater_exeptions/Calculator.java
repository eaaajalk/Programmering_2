package calculater_exeptions;

public class Calculator {
    public Calculator() {
    }

    public int add(int a, int b) {
        return a+b;
    }
    public int subtract(int a, int b) {
        return a-b;
    }
    public int multiply(int a, int b) {
        return a*b;
    }
    public int divide(int a, int b)  {
        if (b == 0) {
            throw new ArithmeticException("Ikke divide med 0");
        }
        return a/b;
    }
}
