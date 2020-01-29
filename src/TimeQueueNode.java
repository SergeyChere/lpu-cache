import java.time.LocalDate;

public class TimeQueueNode {

    private Integer key;
    private LocalDate localDate;
    private Integer timeQueueKey;

    public TimeQueueNode(){}

    public TimeQueueNode(Integer key, LocalDate localDate, Integer timeQueueKey) {
        this.key=key;
        this.localDate=localDate;
        this.timeQueueKey=timeQueueKey;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setTimeQueueKey(Integer timeQueueKey) {
        this.timeQueueKey = timeQueueKey;
    }

    public Integer getKey() {
        return key;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Integer getTimeQueueKey() {
        return timeQueueKey;
    }
}
