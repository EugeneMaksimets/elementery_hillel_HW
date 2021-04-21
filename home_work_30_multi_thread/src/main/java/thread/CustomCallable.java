package thread;

import service.ThreadNameService;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        int result = 0;
        Thread.currentThread().setName("Callable");
        for (int i = 0; i < 1000; i++) {
            result = ThreadNameService.getName();
        }
        return result;
    }

}
