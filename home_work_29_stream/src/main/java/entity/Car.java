package entity;

public class Car {
    private String number;

    public Car(String number) {
        this.number = number;
    }

    public void startEngine(String number) {
        System.out.println("Start engine " + number);
    }

    public static String updateNumberToKiev(String number) {
        return ("аа" + number + "aa").toUpperCase();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
