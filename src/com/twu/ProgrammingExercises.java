package com.twu;

public class ProgrammingExercises {

    private static final String ASTERISK = "*";
    private static final String NEWLINE = "\n";
    private static final String EMPTY_STRING = "";

    private static void checkNIsAtLeastZero(int n) {
        if(n < 0) throw new IllegalArgumentException("n must be 0 or greater");
    }

    private static void printText(String text) {
        System.out.println(text);
    }

    public static String oneAsterisk() {
        return horizontalLine(1);
    }

    public static String horizontalLine(int n) {
        checkNIsAtLeastZero(n);
        return ASTERISK + (n == 1 ? NEWLINE : horizontalLine(--n));
    }

    public static String verticalLine(int n) {
        checkNIsAtLeastZero(n);
        return horizontalLine(1) + (n == 1 ? EMPTY_STRING : verticalLine(--n));
    }

    public static String rightTriangle(int n) {
        checkNIsAtLeastZero(n);
        return (n == 0) ? EMPTY_STRING : rightTriangle(n - 1) + horizontalLine(n);
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
    }

}
