import entity.Worker;
import funcrtionalInterface.ConsumerInterface;
import funcrtionalInterface.FunctionInterface;
import funcrtionalInterface.PredicateInterface;
import funcrtionalInterface.SupplierInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker(1400, "Eugene", 4);
        Worker nextWorker = new Worker(1600, "Alex", 1);

        //PREDICATE INTERFACE ------------------------------------------------------------------------------------------
        PredicateInterface<Double> predicateInterface = amount -> amount > 1500;
        System.out.println("result predicateInterface: " + predicateInterface.getFlag(worker.getAmount()));
        System.out.println("result predicateInterface: " + predicateInterface.getFlag(nextWorker.getAmount()));

        //CONSUMER INTERFACE -------------------------------------------------------------------------------------------
        ConsumerInterface<String> consumerInterface = name -> {
            char[] nameChar = name.toCharArray();
            for (char i : nameChar) {
                System.out.println(i);
            }
        };
        consumerInterface.accept(worker.getName());

        //FUNCTION INTERFACE -------------------------------------------------------------------------------------------
        FunctionInterface<Integer, String> functionInterface = integer -> {
            String result;
            switch (integer) {
                case 1:
                    result = "one";
                    break;
                case 2:
                    result = "two";
                    break;
                case 3:
                    result = "three";
                    break;
                case 4:
                    result = "four";
                    break;
                case 5:
                    result = "five";
                    break;
                case 6:
                    result = "six";
                    break;
                case 7:
                    result = "seven";
                    break;
                case 8:
                    result = "eight";
                    break;
                case 9:
                    result = "nine";
                    break;
                case 10:
                    result = "ten";
                    break;

                default:
                    result = "unknown";
            }
            return result;
        };
        System.out.println("result functionInterface: " + functionInterface.apply(worker.getCountWorker()));

        //SUPPLIER INTERFACE -------------------------------------------------------------------------------------------
        SupplierInterface<Worker> supplierInterface = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write name: ");
            String name = scanner.nextLine();
            System.out.println("Write amount: ");
            double amount = scanner.nextDouble();
            System.out.println("Write number workers: ");
            int number = scanner.nextInt();
            return new Worker(amount, name, number);
        };
        Worker lastWorker = supplierInterface.get();
        System.out.println(lastWorker.toString());
    }
}
