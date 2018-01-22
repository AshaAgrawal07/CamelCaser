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


    @Test
    public void digitBeginningWord() {
        try {
            CamelCaser.camelCase("707this is my string");
            throw new IllegalArgumentException("Invalid format");

        } catch (exception e) {
            System.out.println("Caught illegalArgumentException for word beginning with a number");
        }
    }

    @Test
    public void digitsAsWord() {
        try {
            CamelCaser.camelCase("this is my string 1010101");
            throw new IllegalArgumentException("Invalid format");

        } catch (exception e) {
            System.out.println("Caught illegalArgumentException for number by itself");
        }
    }

    @Test
    public void nullTest() {
        try {
            CamelCaser.camelCase(null);
            throw new IllegalArgumentException("null input");

        } catch (exception e) {
            System.out.println("Caught illegalArgumentException for null string");
        }
    }

    @Test
    public void illegalCharacters() {
        try {
            CamelCaser.camelCase(null);
            throw new IllegalArgumentException("invalid character");

        } catch (exception e) {
            System.out.println("Caught illegalArgumentException for invalid character");
        }
    }
}