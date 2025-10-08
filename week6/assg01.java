package week6;

import java.util.Scanner;

public class assg01 {
    static class Calculator {
        public double multiply() {
            Scanner sc = new Scanner(System.in);
            System.out.print("enter first number: ");
            double a = sc.nextDouble();

            System.out.print("enter second number: ");
            double b=sc.nextDouble();
            return a*b;
        }

        public double multiply(double a, double b) {
            return a*b;
        }

        public double multiply(double a, double b, double c) {
            return a *b*c;
        }

        public double multiply(double[] numbers) {
            double result =1.0;
            for (double num : numbers) {
                result*= num;
            }

            return  result;
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Test no-argument multiply
        System.out.println("Testing no-argument multiply:");
        double result1 = calc.multiply();
        System.out.println("Result: " + result1);

        // Test two-argument multiply
        System.out.println("\ntesting two-argument multiply:");
        System.out.println("2.5 * 3.5 = " + calc.multiply(2.5, 3.5));

        //  test 3-argument multiply
        System.out.println("\nTesting three-argument multiply:");
        System.out.println("2.0 * 3.0 * 4.0 = " + calc.multiply(2.0, 3.0, 4.0));

        // Test array multiply
        double[] numbers = {1.5, 2.5, 3.5, 4.5};
        System.out.println("\nTesting array multiply:");
        System.out.println("result: " + calc.multiply(numbers));
    }
}
