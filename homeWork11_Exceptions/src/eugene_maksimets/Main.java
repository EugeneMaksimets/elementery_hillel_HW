package eugene_maksimets;


import eugene_maksimets.entity.Client;
import eugene_maksimets.exception.WrongFieldException;
import eugene_maksimets.exception.WrongSumException;
import eugene_maksimets.service.ServiceTransaction;
import eugene_maksimets.util.Helper;


import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
//    static ServiceTransaction serviceTransaction = new ServiceTransaction();
//    private static Client client;
//    private static Client client2;

    public static void main(String[] args) {
        String strCheck = checkEx(true);
        String strCheck2 = checkEx(true);
        double amount = checkWrongSum(true);
        Client client = new Client(strCheck, "Maksimetc", "1234567890", amount);
        Client client2 = new Client(strCheck2, "RealMan", "0987654321", 0.0);
        ServiceTransaction.transaction(client, strCheck);
        print(client, client2);
    }

    private static String checkEx(boolean flag) {
        String userId;
        do {
            System.out.println("Enter your ID");
            userId = scanner.nextLine();
            try {
                Helper.checkId(userId);
                flag = false;
            } catch (WrongFieldException exception) {
                System.out.println(exception.getMessage());
            }
        }
        while (flag);
        return userId;
    }

    private static double checkWrongSum(boolean flag) {
        double amount;
        do {
            System.out.println("Write sum");
            amount = scanner.nextDouble();
            try {
                Helper.checkAddMoney(amount);
                flag = false;
            } catch (WrongSumException exception) {
                System.out.println(exception.getMessage());
            }
        }
        while (flag);
        return amount;
    }


    private static void print(Client client, Client client2) {
        String printing = String.format("%s sent %s$ to %s.", client.getSurname(),
                client.getAmount(), client2.getSurname());
        System.out.println(printing);

    }

}



