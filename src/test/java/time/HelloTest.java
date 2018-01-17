package time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    @Test
    public void shouldSayGoodMorningInTheMorning() {
        Hello hello = new Hello();
        assertEquals("Good Morning!", hello.sayHello());
    }

    @Test
    public void shouldSayGoodAfternoonInTheAfternoon() {
        Hello hello = new Hello();
        assertEquals("Good Afternoon!", hello.sayHello());
    }
}
