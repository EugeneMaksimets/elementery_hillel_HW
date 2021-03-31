import entity.Car;
import entity.Card;
import entity.Client;
import entity.Status;
import service.CarService;
import service.ClientService;
import service.CardService;
import service.StatusService;

public class Main {
    public static void main(String[] args) {
        // CREATE ENTITY -----------------------------------------------------------------------------------------------
        // CLIENTS
        Client alex = new Client("Alex", "alexx@gmail.com", 20, 380959509595L);
        Client eugene = new Client("eugene", "Eugene@gmail.com", 25, 380986717294L);
        Client katya = new Client("Katya", "katya@gmail.com", 24, 380979809943L);
        Client alina = new Client("Alina", "alinka@gmail.com", 18, 380939495678L);
        // CARD --------------------------------------------------------------------------------------------------------
        Card firstCard = new Card("0000000001");
        Card secondCard = new Card("0000000003");
        Card thirdCard = new Card("0000000004");
        Card fourthCard = new Card("0000000005");
        // STATUS ------------------------------------------------------------------------------------------------------
        Status low = new Status("LOW",
                "With LOW status, you can use car if it price no more 200$ for day");
        Status standard = new Status("STANDARD",
                "With STANDARD status, you can use car if it price no more 600$ for day");
        Status rich = new Status("RICH",
                "With RICH status, you can use car if it price no more 1000$ for day");
        Status vip = new Status("VIP",
                "With VIP status, you can use car if it price no more 1500$ for day");
        // CAR ---------------------------------------------------------------------------------------------------------
        Car camry = new Car("toyota", 3.5, 2020, 500);
        Car m5 = new Car("bmw", 5.0, 2019, 2000);
        Car c200 = new Car("mercedes", 2.5, 2013, 900);
        Car fiesta = new Car("ford", 1.6, 2001, 150);
        // ADD CARD and STATUS to ENTITY -------------------------------------------------------------------------------
        // ALEX
        firstCard.setStatus(low);
        firstCard.setClient(alex);
        alex.setCard(firstCard);
        // EUGENE
        secondCard.setStatus(standard);
        secondCard.setClient(eugene);
        eugene.setCard(secondCard);
        // KATYA
        thirdCard.setStatus(rich);
        thirdCard.setClient(katya);
        katya.setCard(thirdCard);
        // ALINA
        fourthCard.setStatus(vip);
        fourthCard.setClient(alina);
        alina.setCard(fourthCard);
        // CLIENTS choose CAR ------------------------------------------------------------------------------------------
        fiesta.setClient(alex);
        camry.setClient(eugene);
        c200.setClient(katya);
        m5.setClient(alina);
        //SAVE TO BASE_DATE --------------------------------------------------------------------------------------------
        ClientService clientService = new ClientService();
        clientService.save(alex);
        clientService.save(katya);
        clientService.save(eugene);
        clientService.save(alina);
//        StatusService statusService = new StatusService();
//        statusService.save(low);
//        statusService.save(standard);
//        statusService.save(rich);
//        statusService.save(vip);
//        CardService cardService = new CardService();
//        cardService.save(firstCard);
//        cardService.save(secondCard);
//        cardService.save(thirdCard);
//        cardService.save(fourthCard);
        CarService carService = new CarService();
        carService.save(fiesta);
        carService.save(camry);
        carService.save(m5);
        carService.save(c200);

    }
}
