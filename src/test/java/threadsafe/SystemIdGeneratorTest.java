package threadsafe;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class SystemIdGeneratorTest {

    private IdGenerator idGen = new SystemIdGenerator();

    @Test
    public void idsShouldBeUnique() {
        Long idA = idGen.nextId();
        Long idB = idGen.nextId();
        assertNotEquals("idA " + idA + " idB " + idB, idA, idB);
    }
}
