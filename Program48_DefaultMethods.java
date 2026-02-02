// Default methods in interfaces
public class Program48_DefaultMethods {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start();
        car.honk(); // default method
        
        Vehicle bike = new Bike();
        bike.start();
        bike.honk(); // default method
    }
}

interface Vehicle {
    void start();
    
    // Default method
    default void honk() {
        System.out.println("Honk! Honk!");
    }
    
    // Static method
    static void service() {
        System.out.println("Vehicle servicing...");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting...");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starting...");
    }
    
    @Override
    public void honk() {
        System.out.println("Beep! Beep!");
    }
}
