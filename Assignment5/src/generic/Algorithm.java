package generic;

public final class Algorithm<T extends Number> {
    public T max(T x, T y) {
        return x.doubleValue() > y.doubleValue() ? x : y;
    }
}
