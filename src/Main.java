import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(4);
        CallCenter callCenter = new CallCenter();
        service.execute(new Thread(callCenter::callGeneric));
        service.execute(new Thread(callCenter::specialist));
        service.execute(new Thread(callCenter::specialist));
        service.execute(new Thread(callCenter::specialist));
        service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);
    }
}
