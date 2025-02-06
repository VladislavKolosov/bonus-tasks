package carfactory.factories;

import carfactory.car.Car;

public interface CarFactory {
    Car buildSportsCar();
    Car buildFamilyCar();
}