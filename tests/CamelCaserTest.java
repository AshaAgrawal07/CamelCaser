import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CamelCaserTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void handoutTestCamelCase() {
        assertEquals("thisIsMyString", CamelCaser.camelCase("this is my string"));
    }

    @Test
    public void beginWithSpace() {

        assertEquals("thisIsMyString", CamelCaser.camelCase(" this is my string"));
    }

    @Test
    public void endWithSpace() {

        assertEquals("thisIsMyString", CamelCaser.camelCase("this is my string "));
    }

    @Test
    public void spaceInMiddle() {

            assertEquals("thisIsMyString", CamelCaser.camelCase("this       is my string "));
    }

    @Test
    public void UpperCaseAtBeginning() {

        assertEquals("thisIsMyString", CamelCaser.camelCase("This is my string"));
    }

    @Test
    public void upperCaseInMiddleOfWord() {

        assertEquals("thisIsMyString", CamelCaser.camelCase("thIs is mY stRing"));
    }

    @Test
    public void digitMiddleOfWord() {

        assertEquals("h3110W0r1d", CamelCaser.camelCase("h3110 w0r1d"));
    }

    //------- assertEquals are done
    //------- starting false cases
    //------- the new try-catch methods are outlined by the following site: https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests

    @Test
    public void digitBeginningWord() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_FORMAT);
        CamelCaser.camelCase("707this is my string"); //expect illegal argument exception
    }

    @Test
    public void digitsAsWord() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_FORMAT);
        CamelCaser.camelCase("this is my string 1010101"); //expect illegal argument exception
    }

    @Test
    public void nullTest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_INPUT);
        CamelCaser.camelCase(null); //expect illegal argument exception for the null

    }

    @Test
    public void emptyCountsAsNullTest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_INPUT);
        CamelCaser.camelCase(""); //expect illegal argument exception for the null

    }

    @Test
    public void illegalCharacters() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_CHARACTER);
        CamelCaser.camelCase(">.1< !!!");
    }
}