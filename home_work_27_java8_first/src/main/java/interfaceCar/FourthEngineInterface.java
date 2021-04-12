package interfaceCar;

public interface FourthEngineInterface {
    default void addOil(int oilAmount) {
        System.out.println("You cannot add: " + oilAmount + " liter's in your engine");
    }

    static void getVinCode(String model) {
        System.out.println(model + " BAD vin code: 00000000");
    }

    void startEngine();

    void stopEngine();
}
