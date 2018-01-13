package com.twu;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

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

    private static String fizzBuzzValue(int n) {
        final boolean nDivisibleBy3 = nDivisibleByDivisor(n, 3);
        final boolean nDivisibleBy5 = nDivisibleByDivisor(n, 5);
        return (nDivisibleBy3 ? (FIZZ + (nDivisibleBy5 ? BUZZ : EMPTY_STRING)) : (nDivisibleBy5 ? BUZZ : (EMPTY_STRING + n))) + NEWLINE;
    }

    public static List<Integer> primeFactorsOf(int n) {
        return rangeClosed( 1, n )
                .boxed()
                .filter( a -> isPrimeFactor( a, n ) )
                .collect( toList() );
    }

    private static boolean isPrimeFactor(int n, int num) {
        return isPrimeNumber(n) && nDivisibleByDivisor(num, n);
    }

    public static boolean isPrimeNumber(int n) {
        return n > 1 && rangeClosed( 2, n/2 ).noneMatch( a -> nDivisibleByDivisor( n, a ) );
    }

    private static boolean nDivisibleByDivisor(int n, int divisor) {
        return n % divisor == 0;
    }

    public static void main(String[] args) {
        // Easiest exercise ever
        System.out.println(oneAsterisk());

        // Draw a horizontal line
        System.out.println(horizontalLine(3));

        // Draw a vertical line
        System.out.println(verticalLine(3));

        // Draw a right triangle
        System.out.println(rightTriangle(3));

        // Isosceles Triangle
        System.out.println(isoscelesTriangle(3));

        // Diamond
        System.out.println(diamond(3));

        // Diamond with name
        System.out.println(diamondWithName(3, "Bill"));

        // Fizz Buzz
        System.out.println(fizzBuzz(100));

        // Prime factors
        System.out.println( primeFactorsOf(30));
    }

}
