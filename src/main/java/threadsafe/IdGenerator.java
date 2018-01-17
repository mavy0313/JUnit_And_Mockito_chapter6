package threadsafe;

public interface IdGenerator {
    /**
     * @return unique id
     */
    Long nextId();
}
