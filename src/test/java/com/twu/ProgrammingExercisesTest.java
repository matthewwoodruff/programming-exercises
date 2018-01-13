package com.twu;

import org.junit.Test;

import java.util.List;

import static com.twu.ProgrammingExercises.diamond;
import static com.twu.ProgrammingExercises.diamondWithName;
import static com.twu.ProgrammingExercises.fizzBuzz;
import static com.twu.ProgrammingExercises.horizontalLine;
import static com.twu.ProgrammingExercises.isoscelesTriangle;
import static com.twu.ProgrammingExercises.oneAsterisk;
import static com.twu.ProgrammingExercises.primeFactorsOf;
import static com.twu.ProgrammingExercises.rightTriangle;
import static com.twu.ProgrammingExercises.verticalLine;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProgrammingExercisesTest {

    @Test
    public void shouldGenerateALineWithOneAsterisk() {
        assertThat( oneAsterisk(), is( "*\n" ) );
    }

    @Test
    public void shouldGenerateAHorizontalLineWithANumberOfAsterisks() {
        assertThat( horizontalLine( 3 ), is( "***\n" ) );
        assertThat( horizontalLine( 5 ), is( "*****\n" ) );
    }

    @Test
    public void shouldGenerateAVerticalLineWithANumberOfAsterisks() {
        assertThat( verticalLine( 3 ), is( "*\n*\n*\n" ) );
        assertThat( verticalLine( 5 ), is( "*\n*\n*\n*\n*\n" ) );
    }

    @Test
    public void shouldGenerateARightTriangle() {
        final String expected = "*\n" +
                        "**\n" +
                        "***\n";

        assertThat( rightTriangle( 3 ), is( expected ) );
    }

    @Test
    public void shouldGenerateAnIsoscelesTriangle() {
        final String expected = "  *  \n" +
                " *** \n" +
                "*****\n";

        assertThat( isoscelesTriangle( 3 ), is( expected ) );
    }

    @Test
    public void shouldGenerateADiamond() {
        final String expected = "  *  \n" +
                " *** \n" +
                "*****\n" +
                " *** \n" +
                "  *  \n";

        assertThat( diamond( 3 ), is( expected ) );
    }

    @Test
    public void shouldGenerateADiamondWithName() {
        final String expected = "  *  \n" +
                " *** \n" +
                "Matt\n" +
                " *** \n" +
                "  *  \n";

        assertThat( diamondWithName( 3, "Matt" ), is( expected ) );
    }

    @Test
    public void shouldGenerateFizzBuzz() {
        assertThat( fizzBuzz( 10 ), is( "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n" ) );
    }

    @Test
    public void shouldGeneratePrimeNumbers() {
        assertThat( primeFactorsOf( 30 ), is( asList( 2, 3, 5 ) ) );
    }

    @Test
    public void shouldCalculatePrimeNumbers() {
        final List<Integer> primeNumbers = rangeClosed( 1, 100 )
                .boxed()
                .filter( ProgrammingExercises::isPrimeNumber )
                .collect( toList() );

        assertThat( primeNumbers,
                is( asList( 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97) ) );
    }
}
