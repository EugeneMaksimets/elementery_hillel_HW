package thread;

import service.ThreadNameService;

public class CustomRunnable implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("Runnable");
        for (int i = 0; i < 1000; i++) {
            ThreadNameService.getName();
        }
    }
}
