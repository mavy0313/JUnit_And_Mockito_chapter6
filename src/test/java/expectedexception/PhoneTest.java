package expectedexception;

import org.junit.Ignore;
import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PhoneTest {

    private Phone phone = new Phone();

    @Test
    public void shouldThrowIAEForEmptyNumber() {
        try {
            phone.setNumber(null);
            fail("Should have thrown IllegalArgumentException");
        } catch(IllegalArgumentException iae) {
            assertEquals("number can not be null or empty",
                    iae.getMessage());
        }
    }

    @Test
    public void shouldThrowIAEForPlusPrefixedNumber() {
        try {
            phone.setNumber("+123");
            fail("Should have thrown IllegalArgumentException");
        } catch(IllegalArgumentException iae) {
            assertEquals("plus sign prefix not allowed, " +
                    "number: [+123]", iae.getMessage());
        }
    }

    @Test
    @Ignore
    public void shouldThrowIAEForEmptyNumberLib() {
        catchException(phone).setNumber(null);
        assertTrue(caughtException() instanceof IllegalArgumentException);
        assertEquals("number can not be null or empty",
                caughtException().getMessage());
    }

    @Test
    @Ignore
    public void shouldThrowIAEForPlusPrefixedNumberLib() {
        catchException(phone).setNumber("+123");
        assertTrue(caughtException() instanceof IllegalArgumentException);
        assertEquals("plus sign prefix not allowed, " +
                "number: [+123]", caughtException().getMessage());
    }
}
