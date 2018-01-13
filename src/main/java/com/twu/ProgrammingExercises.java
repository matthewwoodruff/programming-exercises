package com.twu;

import java.util.List;
import java.util.function.Function;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class ProgrammingExercises {

    private static final String ASTERISK = "*";
    private static final String NEWLINE = "\n";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public static String oneAsterisk() {
        return asteriskLine( 1 );
    }

    private static String repeat( String text, int n ) {
        return forCountDo( n, i -> text );
    }

    private static String asterisks( int n ) {
        return repeat( ASTERISK, n );
    }

    private static String line( String text ) {
        return text + NEWLINE;
    }

    public static String asteriskLine( int n ) {
        return line( asterisks( n ) );
    }

    public static String verticalLine( int n ) {
        return repeat( asteriskLine( 1 ), n );
    }

    public static String rightTriangle( int n ) {
        return forCountDo( n, ProgrammingExercises::asteriskLine );
    }

    private static String isoscelesTriangleLine( int row, int rows ) {
        final String padding = repeat( SPACE, rows - row );
        return line( padding + asterisks( ( 2 * row ) - 1 ) + padding );
    }

    public static String isoscelesTriangle( int skipRows, int rows ) {
        return forCountDo( rows - skipRows, i -> isoscelesTriangleLine( i, rows ) );
    }

    private static String reverseIsoscelesTriangle( int skipRows, int rows ) {
        return forCountDo( rows - skipRows, i -> isoscelesTriangleLine( rows - i, rows ) );
    }

    public static String diamond( int n ) {
        return isoscelesTriangle( 0, n ) + reverseIsoscelesTriangle( 1, n );
    }

    public static String diamondWithName( int n, String name ) {
        return isoscelesTriangle( 1, n ) + name + NEWLINE + reverseIsoscelesTriangle( 1, n );
    }

    public static String fizzBuzz( int n ) {
        return forCountDo( n, ProgrammingExercises::fizzBuzzValue );
    }

    private static String fizzBuzzValue( int n ) {
        return line(
                nDivisibleByDivisor( n, 3 ) ?
                        FIZZ + ( nDivisibleByDivisor( n, 5 ) ? BUZZ : EMPTY_STRING ) :
                        nDivisibleByDivisor( n, 5 ) ? BUZZ : valueOf( n ) );
    }

    public static List<Integer> primeFactorsOf( int n ) {
        return rangeClosed( 1, n )
                .boxed()
                .filter( a -> isPrimeFactor( a, n ) )
                .collect( toList() );
    }

    private static boolean isPrimeFactor( int n, int num ) {
        return isPrimeNumber( n ) && nDivisibleByDivisor( num, n );
    }

    public static boolean isPrimeNumber( int n ) {
        return n > 1 && rangeClosed( 2, n / 2 ).noneMatch( a -> nDivisibleByDivisor( n, a ) );
    }

    private static boolean nDivisibleByDivisor( int n, int divisor ) {
        return n % divisor == 0;
    }

    private static String forCountDo( int count, Function<Integer, String> mapper ) {
        return rangeClosed( 1, count ).boxed()
                .map( mapper )
                .reduce( EMPTY_STRING, String::concat );
    }

    public static void main( String[] args ) {
        // Easiest exercise ever
        System.out.println( oneAsterisk() );

        // Draw a horizontal line
        System.out.println( asteriskLine( 3 ) );

        // Draw a vertical line
        System.out.println( verticalLine( 3 ) );

        // Draw a right triangle
        System.out.println( rightTriangle( 3 ) );

        // Isosceles Triangle
        System.out.println( isoscelesTriangle( 0, 3 ) );

        // Diamond
        System.out.println( diamond( 3 ) );

        // Diamond with name
        System.out.println( diamondWithName( 3, "Bill" ) );

        // Fizz Buzz
        System.out.println( fizzBuzz( 100 ) );

        // Prime factors
        System.out.println( primeFactorsOf( 30 ) );
    }

}
