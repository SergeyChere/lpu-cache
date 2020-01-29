import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimeQueue implements Iterable<TimeQueueNode> {
    private List<TimeQueueNode> queue = new ArrayList<>();
    public TimeQueue(){}

    public void add(TimeQueueNode timeQueueNode) {
        if (queue.isEmpty()) {
            queue.add(new TimeQueueNode(timeQueueNode.getKey(), LocalDate.now(), null));
        } else {
            Integer key = queue.get(queue.size()-1).getKey();
            queue.add(new TimeQueueNode(timeQueueNode.getKey(), LocalDate.now(), key));
        }
    }

    public TimeQueueNode peek() {
        return queue.get(queue.size()-1);
    }

    public void update(Integer key) {
        for (Iterator it = queue.iterator(); it.hasNext();) {
            TimeQueueNode node = (TimeQueueNode) it.next();
            if (node.getKey().equals(key)) {
                node.setLocalDate(LocalDate.now());
                queue.add(node);
            }
        }
    }

    public void removeOldest() {
        queue.remove(0);
    }

    public TimeQueueNode getOldestNode() {
        return queue.get(0);
    }

    public TimeQueueNode getYoungest() {
        return peek();
    }

    public int size() {
        return queue.size();
    }

    public TimeQueueNode get(int index) {
        return queue.get(index);
    }

    @Override
    public Iterator<TimeQueueNode> iterator() {
        Iterator<TimeQueueNode> timeQueueNodeIterator = new Iterator<TimeQueueNode>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return true ? queue.size() > index : false;
            }

            @Override
            public TimeQueueNode next() {
                return queue.get(index++);
            }
        };
        return timeQueueNodeIterator;
    }
}
