package entity;

import interfaceCar.FirstEngineInterface;
import interfaceCar.SecondEngineInterface;

public class SpaceCar implements FirstEngineInterface, SecondEngineInterface {
    private String carModel;
    private double oil;

    public SpaceCar(String carModel) {
        this.carModel = carModel;
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
        if (oilAmount == 0) {
            SecondEngineInterface.super.addOil(oilAmount);
        } else {
            FirstEngineInterface.super.addOil(oilAmount);
        }
    }

    @Override
    public void startEngine() {
        System.out.println(carModel + ": start jet engine");
    }

    @Override
    public void stopEngine() {
        System.out.println(carModel + ": stop jet engine");
    }

    @Override
    public String toString() {
        return "SpaceCar{" +
                "carModel='" + carModel + '\'' +
                ", oil=" + oil +
                '}';
    }
}
