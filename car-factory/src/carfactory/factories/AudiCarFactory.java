package carfactory.factories;

import carfactory.car.Car;
import carfactory.car.AudiFamilyCar;
import carfactory.car.AudiSportsCar;

public class AudiCarFactory implements CarFactory {
    @Override
    public Car buildSportsCar() {
        return new AudiSportsCar();
    }

    @Override
    public Car buildFamilyCar() {
        return new AudiFamilyCar();
    }
}
