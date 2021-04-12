package interfaceCar;

public interface SecondEngineInterface {
    default void addOil(int oilAmount) {
        System.out.println("You add air. Nice");
    }

    static void getVinCode(String model) {
        System.out.println(model + " BAD vin code: ≬≬≬≬≬≬≬≬. WANTED!!! car");
    }

    void startEngine();

    void stopEngine();
}
