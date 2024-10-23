package calculator;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal(3);
        BigDecimal bigDecimal2 = new BigDecimal(3.1);
        Calculator<BigDecimal> bigDecimalCalculator = new Calculator<>(bigDecimal1, bigDecimal2);

        System.out.println(bigDecimalCalculator.add());
        System.out.println(bigDecimalCalculator.subtract());
        System.out.println(bigDecimalCalculator.multiply());
        System.out.println(bigDecimalCalculator.divide());
        System.out.println("______________________________________");

        Integer integer1 = 35;
        Integer integer2 = 50;
        Calculator<Integer> integerCalculator = new Calculator<>(integer1, integer2);
        System.out.println(integerCalculator.add());
        System.out.println(integerCalculator.subtract());
        System.out.println(integerCalculator.multiply());
        System.out.println(integerCalculator.divide());

        System.out.println("______________________________________");

        Float float1 = 3.2f;
        Float float2 = 13.3f;
        Calculator<Float> floatCalculator = new Calculator<>(float1, float2);
        System.out.println(floatCalculator.add());
        System.out.println(floatCalculator.subtract());
        System.out.println(floatCalculator.multiply());
        System.out.println(floatCalculator.divide());
        System.out.println("______________________________________");

        Double double1 = 35.0;
        Double double2 = 8.3;
        Calculator<Double> doubleCalculator = new Calculator<>(double1, double2);
        System.out.println(doubleCalculator.add());
        System.out.println(doubleCalculator.subtract());
        System.out.println(doubleCalculator.multiply());
        System.out.println(doubleCalculator.divide());
    }
}
