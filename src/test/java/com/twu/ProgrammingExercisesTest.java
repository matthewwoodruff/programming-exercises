package com.twu;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProgrammingExercisesTest {

    @Test
    public void shouldGenerateALineWithOneAsterisk() {
        assertThat( ProgrammingExercises.oneAsterisk(), is( "*\n" ) );
    }

    @Test
    public void shouldGenerateAHorizontalLineWithANumberOfAsterisks() {
        assertThat( ProgrammingExercises.horizontalLine( 3 ), is( "***\n" ) );
        assertThat( ProgrammingExercises.horizontalLine( 5 ), is( "*****\n" ) );
    }

    @Test
    public void shouldGenerateAVerticalLineWithANumberOfAsterisks() {
        assertThat( ProgrammingExercises.verticalLine( 3 ), is( "*\n*\n*\n" ) );
        assertThat( ProgrammingExercises.verticalLine( 5 ), is( "*\n*\n*\n*\n*\n" ) );
    }

    @Test
    public void shouldGenerateARightTriangle() {
        final String expected = "*\n" +
                        "**\n" +
                        "***\n";

        assertThat( ProgrammingExercises.rightTriangle( 3 ), is( expected ) );
    }

    @Test
    public void shouldGenerateAnIsoscelesTriangle() {
        final String expected = "  *  \n" +
                " *** \n" +
                "*****\n";

        assertThat( ProgrammingExercises.isoscelesTriangle( 3 ), is( expected ) );
    }

    @Test
    public void shouldGenerateADiamond() {
        final String expected = "  *  \n" +
                " *** \n" +
                "*****\n" +
                " *** \n" +
                "  *  \n";

        assertThat( ProgrammingExercises.diamond( 3 ), is( expected ) );
    }

    @Test
    public void shouldGenerateADiamondWithName() {
        final String expected = "  *  \n" +
                " *** \n" +
                "Matt\n" +
                " *** \n" +
                "  *  \n";

        assertThat( ProgrammingExercises.diamondWithName( 3, "Matt" ), is( expected ) );
    }

    @Test
    public void shouldGenerateFizzBuzz() {
        assertThat( ProgrammingExercises.fizzBuzz( 10 ), is( "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n" ) );
    }

    @Test
    public void shouldGeneratePrimeNumbers() {
        assertThat( ProgrammingExercises.generate( 30 ), is( asList(2, 3, 5) ) );
    }

}
