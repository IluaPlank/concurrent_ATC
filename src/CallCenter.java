import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    private int count = 0;
    final int CALL_SIZE = 10;
    final int SLEEP_ATC = 1000;
    final int SLEEP_TAKE = 4000;


    public void callGeneric() {
        while (true) {
            for (int i = 0; i < CALL_SIZE; i++) {
                count++;
                queue.add("звонок номер: " + count + ".");
            }
            try {
                Thread.sleep(SLEEP_ATC);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void specialist() {
        while (true) {
            if (queue.isEmpty()) {
                continue;
            }
            System.out.println("Оператор - " + Thread.currentThread().getName() + " принял " + queue.poll());
            try {
                Thread.sleep(SLEEP_TAKE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



