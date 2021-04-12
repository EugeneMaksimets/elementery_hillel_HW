package entity;

import interfaceCar.FourthEngineInterface;
import interfaceCar.ThirdEngineInterface;

public class BrokenCar implements ThirdEngineInterface, FourthEngineInterface {
    private String carModel;
    private double oil;

    public BrokenCar(String carModel, double oil) {
        this.carModel = carModel;
        this.oil = oil;
    }

    public double getOil() {
        return oil;
    }

    public void setOil(double oil) {
        this.oil = oil;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public void addOil(int oilAmount) {
        if ((getOil() + oilAmount) <= 5) {
            ThirdEngineInterface.super.addOil(oilAmount);
            setOil(getOil() + oilAmount);
        } else {
            FourthEngineInterface.super.addOil(oilAmount);
        }
    }

    @Override
    public void startEngine() {
        System.out.println(carModel + ": try start engine");
    }

    @Override
    public void stopEngine() {
        System.out.println(carModel + ": stop engine");
    }

    @Override
    public String toString() {
        return "CarBroken{" +
                "carModel='" + carModel + '\'' +
                ", oil=" + oil +
                '}';
    }
}
