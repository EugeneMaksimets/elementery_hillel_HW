package entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
    Lock lock = new ReentrantLock();

    public void startEngine() {
        lock.lock();
        System.out.println("Start engine - " + Thread.currentThread().getName());
        drive();
    }

    private void drive() {
        System.out.println("Car is running - " + Thread.currentThread().getName());
        stopEngine();
    }

    private void stopEngine() {
        System.out.println("Stop engine - " + Thread.currentThread().getName());
        lock.unlock();
    }
}
