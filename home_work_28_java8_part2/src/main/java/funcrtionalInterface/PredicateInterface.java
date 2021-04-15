package funcrtionalInterface;

@FunctionalInterface
public interface PredicateInterface<T> {
    boolean getFlag(T t);
}