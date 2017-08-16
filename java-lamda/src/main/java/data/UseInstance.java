package data;

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
	public void accept(T instance) throws X;
}
