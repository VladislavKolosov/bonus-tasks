package carfactory.factories;

import carfactory.car.BMWFamilyCar;
import carfactory.car.BMWSportCar;
import carfactory.car.Car;

public class BMWCarFactory implements CarFactory {
    @Override
    public Car buildSportsCar() {
        return new BMWSportCar();
    }

    @Override
    public Car buildFamilyCar() {
        return new BMWFamilyCar();
    }
}
