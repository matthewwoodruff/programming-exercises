package com.twu;

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

    private static void printText(String text) {
        System.out.println(text);
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

    public static void main(String[] args) {
        // Easiest exercise ever
        printText(oneAsterisk());

        // Draw a horizontal line
        printText(horizontalLine(3));

        // Draw a vertical line
        printText(verticalLine(3));

        // Draw a right triangle
        printText(rightTriangle(3));

        // Isosceles Triangle
        printText(isoscelesTriangle(3));

        // Diamond
        printText(diamond(3));

        // Diamond with name
        printText(diamondWithName(3, "Bill"));

        // Fizz Buzz
        printText(fizzBuzz(100));
    }

}
