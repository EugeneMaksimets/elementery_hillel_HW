import entity.Car;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        // ATOMIC ------------------------------------------------------------------------------------------------------
        AtomicInteger atomicInteger = new AtomicInteger(20001);
        Thread firstThread = new Thread(() ->
        {
            for (int i = 0; i < 10000; i++) {
                Thread someThread = new Thread(atomicInteger::decrementAndGet);
                someThread.start();
            }

        });
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                Thread nextThread = new Thread(atomicInteger::decrementAndGet);
                nextThread.start();
            }
        });
        firstThread.start();
        secondThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("atomicInteger = " + atomicInteger.get());
        // LOCK --------------------------------------------------------------------------------------------------------
        Car car = new Car();
        Thread firstLockThread = new Thread(car::startEngine);
        Thread secondLockThread = new Thread(car::startEngine);
        Thread thirdLockThread = new Thread(car::startEngine);
        firstLockThread.setName("FIRST lock");
        secondLockThread.setName("SECOND lock");
        thirdLockThread.setName("THIRD lock");
        firstLockThread.start();
        secondLockThread.start();
        thirdLockThread.start();
    }
}
