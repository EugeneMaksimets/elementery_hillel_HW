package interfaceCar;

public interface ThirdEngineInterface {
    default void addOil(int oilAmount) {
        System.out.println("You add: " + oilAmount + " liter's in your engine");
    }

    static void getVinCode(String model) {
        System.out.println(model + " vinCode: 2V43K2FJ2222");
    }

    void startEngine();

    void stopEngine();
}
