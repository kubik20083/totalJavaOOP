package model;

public class Calculator implements ComplexOperations<Double> {

    public Double[] operation(char operation, Double[] first, Double[] second) {
        switch (operation) {
            case '+':
                return addition(first, second);
            case '-':
                return subtraction(first, second);
            case '*':
                return multiplication(first, second);
            case '/':
                if (second[0] == 0 && second[1] == 0)
                    throw new IllegalArgumentException("Division by zero is prohibited");
                return division(first, second);
        }
        throw new IllegalArgumentException("Wrong operation");
    }

    @Override
    public Double[] parse(String complexNumber) {
        Double[] complex = new Double[2];
        String[] operands = complexNumber.split(" ");
        if (operands.length != 2)
            throw new IllegalArgumentException("Неверный формат ввода");
        complex[0] = Double.parseDouble(operands[0].trim());
        complex[1] = Double.parseDouble(operands[1].trim());
        return complex;
    }

    @Override
    public Double[] addition(Double[] first, Double[] second) {
        return new Double[] { first[0] + second[0], first[1] + second[1] };
    }

    @Override
    public Double[] subtraction(Double[] first, Double[] second) {
        return new Double[] { first[0] - second[0], first[1] - second[1] };
    }

    @Override
    public Double[] multiplication(Double[] first, Double[] second) {
        Double x = first[0];
        Double y = first[1];
        Double u = second[0];
        Double v = second[1];
        return new Double[] { (x * u - y * v), (x * v + y * u) };
    }

    @Override
    public Double[] division(Double[] first, Double[] second) {
        Double x = second[0];
        Double y = second[1];
        Double u = first[0];
        Double v = first[1];
        return new Double[] { (u * x + v * y) / (x * x + y * y),
                (v * x - u * y) / (x * x + y * y) };
    }
}
