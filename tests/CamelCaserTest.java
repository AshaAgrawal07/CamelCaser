import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CamelCaserTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void handoutTestCamelCase() {
        System.out.println(CamelCaser.camelCase("this is my string"));
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

    @Test (expected = IllegalArgumentException.class)
    public void digitBeginningWord() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_FORMAT);
        CamelCaser.camelCase("707this is my string"); //expect illegal argument exception
        /*try {
            CamelCaser.camelCase("707this is my string"); //expect illegal argument exception
            fail("My method didn't throw when I expected it to");
        } catch (Exception e){
            System.out.println("Caught illegalArgumentException for word beginning with a number" + e.getMessage());
        }*/

        /*try {
            CamelCaser.camelCase("707this is my string");
            throw new IllegalArgumentException("Invalid format");

        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for word beginning with a number" + e.getMessage());
        }*/
    }

    @Test(expected = IllegalArgumentException.class)
    public void digitsAsWord() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_FORMAT);
        CamelCaser.camelCase("this is my string 1010101"); //expect illegal argument exception

        /*try {
            CamelCaser.camelCase("this is my string 1010101"); //expect illegal argument exception
            fail("My method didn't throw when I expected it to");
        } catch (Exception e){
            System.out.println("Caught illegalArgumentException for number by itself" + e.getMessage());
        }*/

        /*try {
            CamelCaser.camelCase("this is my string 1010101");
            throw new IllegalArgumentException("Invalid format");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for number by itself" + e.getMessage());
        }*/
    }

    @Test (expected = IllegalArgumentException.class)
    public void nullTest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_FORMAT);
        CamelCaser.camelCase(null); //expect illegal argument exception for the null
        /*try {
            CamelCaser.camelCase(null); //expect illegal argument exception for the null
            fail("My method didn't throw when I expected it to");
        } catch (Exception e){
            System.out.println("Caught illegalArgumentException for null string" + e.getMessage());
        }*/

        /*try {
            CamelCaser.camelCase(null);
            throw new IllegalArgumentException("null input");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for null string" + e.getMessage());
        }*/
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyCountsAsNullTest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_FORMAT);
        CamelCaser.camelCase(""); //expect illegal argument exception for the null
        /*try {
            CamelCaser.camelCase(""); //expect illegal argument exception for the null
            fail("My method didn't throw when I expected it to");
        } catch (Exception e){
            System.out.println("Caught illegalArgumentException for null string" + e.getMessage());
        }*/
        /*try {
            CamelCaser.camelCase("");
            throw new IllegalArgumentException("null input");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for null string" + e.getMessage());
        }*/
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalCharacters() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INVALID_CHARACTER);
        CamelCaser.camelCase(">.< hi!"); //expect illegal argument exception for invalid character
        /*try {
            CamelCaser.camelCase(">.< hi!"); //expect illegal argument exception for invalid character
            fail("My method didn't throw when I expected it to");
        } catch (Exception e){
            System.out.println("Caught illegalArgumentException for invalid character" + e.getMessage());
        }*/

        /*try {
            CamelCaser.camelCase(">.< hi!");
            throw new IllegalArgumentException("invalid character");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for invalid character" + e.getMessage());
        }*/
    }
}