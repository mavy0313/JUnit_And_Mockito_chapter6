package threadsafe;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class AtomicIdGeneratorTest {

    private IdGenerator idGen = new AtomicIdGenerator();

    @Test
    public void idsShouldBeUnique() {
        Long idA = idGen.nextId();
        Long idB = idGen.nextId();
        assertNotEquals("idA " + idA + " idB " + idB, idA, idB);
    }
}
