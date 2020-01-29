import java.time.LocalDate;
import java.util.*;

public class Main {
    static Hashtable<Integer, LocalDate> lpuCache = new Hashtable<>();
    static TimeQueue timeQueue = new TimeQueue();
    static Random random = new Random();
    static int maxQueueSize = 5;

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++) {
            if (i<5) {
                System.out.println(calculateWithCache(random.nextInt(5)));
            } else {
                System.out.println(calculateWithCache(random.nextInt(100)));
            }
            Thread.sleep(1000);
        }
        System.out.println(lpuCache.toString());
    }

    private static LocalDate calculateWithCache(Integer key) {
        if (lpuCache.contains(key)) {
            timeQueue.update(key);
        }
        LocalDate result = timeQueue.peek().getLocalDate();
        if(lpuCache.size()==maxQueueSize) {
            timeQueue.removeOldest();
            for (int i=1; i<timeQueue.size()-2; i++) {
                timeQueue.add(timeQueue.get(i));
            }
            timeQueue.add(new TimeQueueNode(key, LocalDate.now(), timeQueue.getYoungest().getKey()));
            Integer minKey = timeQueue.getOldestNode().getKey();
            lpuCache.remove(minKey);
        }
        lpuCache.put(key, result);
        return result;
    }
}
