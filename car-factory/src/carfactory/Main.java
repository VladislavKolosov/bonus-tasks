package carfactory;

import carfactory.car.Car;
import carfactory.factories.AudiCarFactory;
import carfactory.factories.CarFactory;
import carfactory.factories.BMWCarFactory;

public class Main {
    public static void main(String[] args) {
        CarFactory bmwCarFactory = new BMWCarFactory();
        Car familyBMW = bmwCarFactory.buildFamilyCar();
        System.out.println(familyBMW.getBrand() + " " + familyBMW.getModel());

        Car sportBMW = bmwCarFactory.buildSportsCar();
        System.out.println(sportBMW.getBrand() + " " + sportBMW.getModel());

        CarFactory audiCarFactory = new AudiCarFactory();
        Car familyAudi = audiCarFactory.buildFamilyCar();
        System.out.println(familyAudi.getBrand() + " " + familyAudi.getModel());

        Car sportAudi = audiCarFactory.buildSportsCar();
        System.out.println(sportAudi.getBrand() + " " + sportAudi.getModel());


    }
}
