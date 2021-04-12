import entity.BrokenCar;
import entity.SpaceCar;
import interfaceCar.FirstEngineInterface;
import interfaceCar.FourthEngineInterface;
import interfaceCar.SecondEngineInterface;
import interfaceCar.ThirdEngineInterface;
import util.MailValidation;

public class Main {
    public static void main(String[] args) {
        //THIRD AND FOURTH INTERFACE's ---------------------------------------------------------------------------------
        BrokenCar brokenCar = new BrokenCar("Ford", 3);
        brokenCar.addOil(2);
        brokenCar.addOil(4);
        ThirdEngineInterface.getVinCode(brokenCar.getCarModel());
        FourthEngineInterface.getVinCode(brokenCar.getCarModel());
        System.out.println(brokenCar.toString());
        brokenCar.startEngine();
        brokenCar.stopEngine();
        System.out.println("--------------------------------------------------------------------------------------------");
        //FIRST AND SECOND INTERFACE's ---------------------------------------------------------------------------------
        SpaceCar spaceCar = new SpaceCar("Normandy");
        spaceCar.addOil(0);
        spaceCar.addOil(2);
        FirstEngineInterface.getVinCode(spaceCar.getCarModel());
        SecondEngineInterface.getVinCode(spaceCar.getCarModel());
        System.out.println(spaceCar.toString());
        spaceCar.startEngine();
        spaceCar.stopEngine();
        System.out.println("OPTIONAL -----------------------------------------------------------------------------------");
        //OPTIONAL -----------------------------------------------------------------------------------------------------
        MailValidation.validation("e.maksimets@gmail.com");
        MailValidation.validation(null);
        MailValidation.validation("");
        MailValidation.validation("1233l");
    }
}
