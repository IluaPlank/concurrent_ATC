import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4);
        CallCenter callCenter = new CallCenter();
        service.execute(new Thread(callCenter::callGeneric));

        for (int i = 0; i < 3; i++) {
            service.execute(new Thread(() -> {
                try {
                    callCenter.specialist();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        service.shutdown();
    }
}
