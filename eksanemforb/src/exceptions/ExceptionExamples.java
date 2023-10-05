package exceptions;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExamples {
    public static void main(String[] args) {
        ExceptionExamples examples = new ExceptionExamples();
        examples.divideByZero();
        examples.nullPointerException();
        examples.arrayIndexOutOfBounds();
        examples.numberFormatException();
        examples.customException();
        examples.classCastException();
        examples.arithmeticException();
        examples.inputMismatchException();
        examples.stringIndexOutOfBoundsException();
    }

    // 1. Try-Catch: ArithmeticException - Division med nul
    public void divideByZero() {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Fejl: Division med nul er ikke tilladt.");
        }
    }

    // 3. Try-Catch: NullPointerException - Null-reference
    public void nullPointerException() {
        try {
            String str = null;
            int length = str.length();
            System.out.println(length);
        } catch (NullPointerException e) {
            System.out.println("Fejl: Objektet er null.");
        }
    }

    // 4. Try-Catch: ArrayIndexOutOfBoundsException - Ugyldig array-indeksering
    public void arrayIndexOutOfBounds() {
        try {
            int[] array = new int[5];
            int element = array[10];
            System.out.println(element);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fejl: Ugyldig array-indeksering.");
        }
    }

    // 5. Try-Catch: NumberFormatException - Ugyldig talformat
    public void numberFormatException() {
        try {
            String str = "ABC";
            int number = Integer.parseInt(str);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("Fejl: Ugyldigt talformat.");
        }
    }

    // 6. Throw: Brugerdefineret exception
    public void customException() {
        try {
            throw new MyCustomException("Dette er en brugerdefineret exception.");
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
        }
    }

    // 7. Throw: ClassCastException - Ugyldig typekonvertering
    public void classCastException() {
        try {
            Object obj = new Integer(10);
            String str = (String) obj;
            System.out.println(str);
        } catch (ClassCastException e) {
            System.out.println("Fejl: Ugyldig typekonvertering.");
        }
    }

    // 8. Throw: ArithmeticException - Division med nul
    public void arithmeticException() {
        try {
            throw new ArithmeticException("Dette er en ArithmeticException.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    // 9. Throw: InputMismatchException - Ugyldig input
    public void inputMismatchException() {
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println(number);
        } catch (InputMismatchException e) {
            System.out.println("Fejl: Ugyldig input.");
        }
    }

    // 10. Throw: StringIndexOutOfBoundsException - Ugyldig strengindeksering
    public void stringIndexOutOfBoundsException() {
        try {
            String str = "Hello";
            char ch = str.charAt(10);
            System.out.println(ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Fejl: Ugyldig strengindeksering.");
        }
    }

    // Brugerdefineret exception
    class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }
}
