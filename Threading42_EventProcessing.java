import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

// Event processing with async handling
public class Threading42_EventProcessing {
    static class Event {
        String name;
        long timestamp;
        
        Event(String name) {
            this.name = name;
            this.timestamp = System.currentTimeMillis();
        }
    }
    
    static class EventProcessor {
        ConcurrentLinkedQueue<Event> events = new ConcurrentLinkedQueue<>();
        
        void publishEvent(String eventName) {
            CompletableFuture.runAsync(() -> {
                Event event = new Event(eventName);
                events.add(event);
                System.out.println("Published: " + eventName);
            });
        }
        
        void processEvents() {
            while (!events.isEmpty()) {
                Event event = events.poll();
                if (event != null) {
                    System.out.println("Processing: " + event.name);
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        EventProcessor processor = new EventProcessor();
        
        for (int i = 1; i <= 5; i++) {
            processor.publishEvent("Event-" + i);
        }
        
        Thread.sleep(500);
        processor.processEvents();
    }
}
