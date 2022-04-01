import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    private int count = 0;
    final int CALL_SIZE = 10;
    final int SLEEP_ATC = 1000;
    final int SLEEP_TAKE = 4000;
    final int CALL_MAX = 30;


    public void callGeneric() {
        while (count < CALL_MAX) {
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

    public void specialist() throws InterruptedException {
        Thread.sleep(SLEEP_ATC);
        while (true) {
            String calling = queue.poll();
            if (calling == null){
                break;
            }
            System.out.println("Оператор - " + Thread.currentThread().getName() + " принял " + calling);
            Thread.sleep(SLEEP_TAKE);

        }
    }
}



