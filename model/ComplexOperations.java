package model;

public interface ComplexOperations<T extends Number> {
        public T[] parse(String complexNumber);

        public T[] operation(char operation, T[] first, T[] second);

        public T[] addition(T[] first, T[] second);

        public T[] subtraction(T[] first, T[] second);

        public T[] multiplication(T[] first, T[] second);

        public T[] division(T[] first, T[] second);

}
