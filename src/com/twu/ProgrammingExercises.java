package com.twu;

import java.util.ArrayList;
import java.util.List;

public class ProgrammingExercises {

    private static final String ASTERISK = "*";
    private static final String NEWLINE = "\n";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private static boolean isNZero(int n) {
        if(n < 0) throw new IllegalArgumentException("n must be 0 or greater");
        return n == 0;
    }

    private static void printObject(Object object) {
        System.out.println(object.toString());
    }

    public static String oneAsterisk() {
        return horizontalLine(1);
    }

    private static String repeat(String text, int n) {
        return isNZero(n) ? EMPTY_STRING : text + repeat(text, --n);
    }

    private static String asteriskLine(int n) {
        return repeat(ASTERISK, n);
    }

    public static String horizontalLine(int n) {
        return asteriskLine(n) + NEWLINE;
    }

    public static String verticalLine(int n) {
        return isNZero(n) ? EMPTY_STRING : horizontalLine(1) + verticalLine(--n);
    }

    public static String rightTriangle(int n) {
        return isNZero(n) ? EMPTY_STRING : rightTriangle(n - 1) + horizontalLine(n);
    }

    public static String isoscelesTriangleLine(int row, int rows) {
        final String paddingText = repeat(SPACE, rows - row);
        return paddingText + asteriskLine((2 * row) - 1) + paddingText + NEWLINE;
    }

    private static String isoscelesTriangle(int row, int rows) {
        return isNZero(row) ? EMPTY_STRING : isoscelesTriangle(row - 1, rows) + isoscelesTriangleLine(row, rows);
    }

    private static String reverseIsoscelesTriangle(int row, int rows) {
        return isNZero(row) ? EMPTY_STRING : isoscelesTriangleLine(row, rows) + isoscelesTriangle(--row, rows);
    }

    public static String isoscelesTriangle(int n) {
        return isoscelesTriangle(n, n);
    }

    public static String diamond(int n) {
        return isoscelesTriangle(n) + reverseIsoscelesTriangle(n-1, n);
    }

    public static String diamondWithName(int n, String name) {
        return isoscelesTriangle(n-1, n) + name + NEWLINE + reverseIsoscelesTriangle(n-1, n);
    }

    public static String fizzBuzz(int n) {
        return isNZero(n) ? EMPTY_STRING : fizzBuzz(n - 1) + fizzBuzzValue(n);
    }

    public static String fizzBuzzValue(int n) {
        final boolean nDivisibleBy3 = nDivisibleByDivisor(n, 3);
        final boolean nDivisibleBy5 = nDivisibleByDivisor(n, 5);
        return (nDivisibleBy3 ? (FIZZ + (nDivisibleBy5 ? BUZZ : EMPTY_STRING)) : (nDivisibleBy5 ? BUZZ : (EMPTY_STRING + n))) + NEWLINE;
    }

    private static boolean nDivisibleByDivisor(int n, int divisor) {
        return n % divisor == 0;
    }

    private static boolean isPrimeNumber(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++)
            if (nDivisibleByDivisor(n, i))
                return false;
        return true;
    }

    private static boolean isPrimeFactor(int n, int num) {
        return isPrimeNumber(n) && nDivisibleByDivisor(num, n);
    }

    public static List<Integer> generate(int n, int num) {
        final List<Integer> list = isNZero(n) ? new ArrayList<Integer>() : generate(n - 1, num);
        if (isPrimeFactor(n, num))
            list.add(n);
        return list;
    }

    public static List<Integer> generate(int n) {
        return generate(n, n);
    }

    public static void main(String[] args) {
        // Easiest exercise ever
        printObject(oneAsterisk());

        // Draw a horizontal line
        printObject(horizontalLine(3));

        // Draw a vertical line
        printObject(verticalLine(3));

        // Draw a right triangle
        printObject(rightTriangle(3));

        // Isosceles Triangle
        printObject(isoscelesTriangle(3));

        // Diamond
        printObject(diamond(3));

        // Diamond with name
        printObject(diamondWithName(3, "Bill"));

        // Fizz Buzz
        printObject(fizzBuzz(100));

        // Prime factors
        printObject(generate(30));
    }

}
