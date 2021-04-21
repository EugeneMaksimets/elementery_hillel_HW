import entity.Card;
import entity.Client;
import thread.CustomCallable;
import thread.CustomRunnable;
import thread.CustomThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        //  THREAD -----------------------------------------------------------------------------------------------------
        CustomThread thread = new CustomThread();
        // RUNNABLE ----------------------------------------------------------------------------------------------------
        CustomRunnable runnable = new CustomRunnable();
        Thread threadRunnable = new Thread(runnable);
        // CALLABLE ----------------------------------------------------------------------------------------------------
        CustomCallable customCallable = new CustomCallable();
        FutureTask<Integer> task = new FutureTask<>(customCallable);
        Thread callable = new Thread(task);
        // START -------------------------------------------------------------------------------------------------------
        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        threadRunnable.start();
//        try {
//            threadRunnable.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        callable.start();
//        try {
//            callable.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            Integer result = task.get();
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // DEADLOCK ----------------------------------------------------------------------------------------------------
        Card card = new Card();
        Client client = new Client();
        client.setCard(card);
        card.setClient(client);
        Thread threadClient = new Thread(() -> System.out.println(card.getClient()));
        Thread threadCard = new Thread(() -> System.out.println(client.getCard()));
        threadClient.start();
        threadCard.start();
        // TEN start's -------------------------------------------------------------------------------------------------
        // TASK 5.1 = 2484-3000
        // TASK 5.2 = 2102-3000
        // TASK 5.3 = 3000-3000

    }
}
