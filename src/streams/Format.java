package streams;

public interface Format<T> {
    String accept(T t);
}
