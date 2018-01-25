package exercises.statetesting;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseTest {

    @Test
    public void shouldReturnReversedString() {
        assertEquals("cba", StringUtils.reverse("abc"));
    }

    @Test
    public void shouldReturnEmptyString() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    public void shouldReturnDigitStrings() {
        assertEquals("123", StringUtils.reverse("321"));
    }

    @Test
    public void shouldReturnSpace() {
        assertEquals(" ", StringUtils.reverse(" "));
    }

    @Test
    public void shouldReturnNull() {
        assertEquals(null, StringUtils.reverse(null));
    }
}
