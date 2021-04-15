package funcrtionalInterface;

@FunctionalInterface
public interface FunctionInterface<T, R> {
    R apply(T t);
}
