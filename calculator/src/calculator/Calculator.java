package calculator;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator<T extends Number> {
    private T firstNumber;
    private T secondNumber;

    public Calculator(T firstNumber, T secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public T add() {
        if (firstNumber instanceof Integer) {
            return (T) Integer.valueOf(firstNumber.intValue() + secondNumber.intValue());
        } else if (firstNumber instanceof Double) {
            return (T) Double.valueOf(firstNumber.doubleValue() + secondNumber.doubleValue());
        } else if (firstNumber instanceof Float) {
            return (T) Float.valueOf(firstNumber.floatValue() + secondNumber.floatValue());
        } else if (firstNumber instanceof BigDecimal) {
            return (T) ((BigDecimal) firstNumber).add((BigDecimal) secondNumber);
        }
        throw new RuntimeException("error type");
    }

    public T subtract(){
        if (firstNumber instanceof Integer) {
            return (T) Integer.valueOf(firstNumber.intValue() - secondNumber.intValue());
        } else if (firstNumber instanceof Double) {
            return (T) Double.valueOf(firstNumber.doubleValue() - secondNumber.doubleValue());
        } else if (firstNumber instanceof Float) {
            return (T) Float.valueOf(firstNumber.floatValue() - secondNumber.floatValue());
        } else if (firstNumber instanceof BigDecimal) {
            return (T) ((BigDecimal) firstNumber).subtract((BigDecimal) secondNumber);
        }
        throw new RuntimeException("error type");
    }

    public T multiply(){
        if (firstNumber instanceof Integer) {
            return (T) Integer.valueOf(firstNumber.intValue() * secondNumber.intValue());
        } else if (firstNumber instanceof Double) {
            return (T) Double.valueOf(firstNumber.doubleValue() * secondNumber.doubleValue());
        } else if (firstNumber instanceof Float) {
            return (T) Float.valueOf(firstNumber.floatValue() * secondNumber.floatValue());
        } else if (firstNumber instanceof BigDecimal) {
            return (T) ((BigDecimal) firstNumber).multiply((BigDecimal) secondNumber);
        }
        throw new RuntimeException("error type");
    }
    public T divide(){

        if (firstNumber instanceof Integer) {
            return (T) Integer.valueOf(firstNumber.intValue() / secondNumber.intValue());
        } else if (firstNumber instanceof Double) {
            return (T) Double.valueOf(firstNumber.doubleValue() / secondNumber.doubleValue());
        } else if (firstNumber instanceof Float) {
            return (T) Float.valueOf(firstNumber.floatValue() / secondNumber.floatValue());
        } else if (firstNumber instanceof BigDecimal) {
            return (T) ((BigDecimal) firstNumber).divide((BigDecimal) secondNumber, RoundingMode.HALF_UP);
        }
        throw new RuntimeException("error type");
    }
}

