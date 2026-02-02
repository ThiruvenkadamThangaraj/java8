import java.time.*;
import java.time.format.DateTimeFormatter;

// Java 8 Date/Time API
public class Program49_DateTimeAPI {
    public static void main(String[] args) {
        // LocalDate
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
        
        LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 15);
        System.out.println("Birthday: " + birthday);
        
        // LocalTime
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);
        
        // LocalDateTime
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Date and time: " + dateTime);
        
        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatted = dateTime.format(formatter);
        System.out.println("Formatted: " + formatted);
        
        // Period and Duration
        LocalDate futureDate = today.plusDays(30);
        System.out.println("30 days from now: " + futureDate);
        
        Period period = Period.between(today, futureDate);
        System.out.println("Period: " + period.getDays() + " days");
    }
}
