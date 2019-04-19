package Application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {



    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(new ThreadApplication(), 0, 1, TimeUnit.HOURS);
        executor.scheduleWithFixedDelay(new ThreadApplication(), 0, 1, TimeUnit.HOURS);

    }
}

