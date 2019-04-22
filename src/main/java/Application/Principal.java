package Application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {


/*
    Author: Joseph Alexandre.
    E-mail: j.alexandremmfreitas@gmail.com
    TODO: Desenvolvimento encerrado por tempo indeterminado. 22/04/2019.
 */
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(new ThreadApplication(), 0, 5, TimeUnit.SECONDS);

    }
}

