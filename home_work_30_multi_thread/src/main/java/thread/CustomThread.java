package thread;

import service.ThreadNameService;

public class CustomThread extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("Custom_Thread");
        for (int i = 0; i < 1000; i++) {
            ThreadNameService.getName();
        }
    }
}
