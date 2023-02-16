package example_lambda_expressions.example5;
@FunctionalInterface
public interface IGenericInterface<T> {
    // generic method
    T func(T t);
}
