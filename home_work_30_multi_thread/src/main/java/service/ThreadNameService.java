package service;

public class ThreadNameService {
    private static int count;

    public static int getName() {
        System.out.println("Name Thread: " + Thread.currentThread().getName() + "\n Count Thread:" + count);
        count++;
        return count;
    }
}
