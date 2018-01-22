import org.junit.Test;

import static org.junit.Assert.*;

public class CamelCaserTest {

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

    @Test (expected = IllegalArgumentException.class)
    public void digitBeginningWord() {
        CamelCaser.camelCase("707this is my string"); //expect illegal argument exception
        /*try {
            CamelCaser.camelCase("707this is my string");
            throw new IllegalArgumentException("Invalid format");

        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for word beginning with a number" + e.getMessage());
        }*/
    }

    @Test(expected = IllegalArgumentException.class)
    public void digitsAsWord() {
        CamelCaser.camelCase("this is my string 1010101"); //expect illegal argument exception
        /*try {
            CamelCaser.camelCase("this is my string 1010101");
            throw new IllegalArgumentException("Invalid format");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for number by itself" + e.getMessage());
        }*/
    }

    @Test (expected = IllegalArgumentException.class)
    public void nullTest() {
        CamelCaser.camelCase(null); //expect illegal argument exception for the null
        /*try {
            CamelCaser.camelCase(null);
            throw new IllegalArgumentException("null input");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for null string" + e.getMessage());
        }*/
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyCountsAsNullTest() {
        CamelCaser.camelCase(""); //expect illegal argument exception for the null
        /*try {
            CamelCaser.camelCase("");
            throw new IllegalArgumentException("null input");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for null string" + e.getMessage());
        }*/
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalCharacters() {
        CamelCaser.camelCase(">.< hi!"); //expect illegal argument exception for invalid character
        /*try {
            CamelCaser.camelCase(">.< hi!");
            throw new IllegalArgumentException("invalid character");
        } catch (Exception e) {
            System.out.println("Caught illegalArgumentException for invalid character" + e.getMessage());
        }*/
    }
}