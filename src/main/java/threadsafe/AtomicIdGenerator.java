package threadsafe;

public class AtomicIdGenerator implements IdGenerator {

    private static Long nextId = System.currentTimeMillis();

    synchronized
    public Long nextId() {
        return nextId++;
    }
}
