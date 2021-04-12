package interfaceCar;

public interface FirstEngineInterface {
    default void addOil(int oilAmount) {
        System.out.println("You needn't oil in SPACE car. You can try sell " + oilAmount + " liters machine oil");
    }

    static void getVinCode(String model) {
        System.out.println(model + " vin code: ⨊∓×⩲~⋢");
    }

    void startEngine();

    void stopEngine();
}
