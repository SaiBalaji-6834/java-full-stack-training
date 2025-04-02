package DAY5;

import java.util.*;

class Passenger {
    private String name;
    private String ticketClass;
    private long bookingTime;

    public Passenger(String name, String ticketClass, long bookingTime) {
        this.name = name;
        this.ticketClass = ticketClass;
        this.bookingTime = bookingTime;
    }

    public static Comparator<Passenger> PriorityComparator = (p1, p2) -> {
        int classCompare = p2.ticketClass.compareTo(p1.ticketClass); // Higher class first
        if (classCompare != 0) return classCompare;
        return Long.compare(p1.bookingTime, p2.bookingTime); // Earlier booking first
    };

    @Override
    public String toString() {
        return name + " (" + ticketClass + ") - Booked at: " + bookingTime;
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        PriorityQueue<Passenger> bookingQueue = new PriorityQueue<>(Passenger.PriorityComparator);

        bookingQueue.add(new Passenger("Alice", "Business", 1000));
        bookingQueue.add(new Passenger("Bob", "Economy", 1001));
        bookingQueue.add(new Passenger("Charlie", "Business", 999));

        System.out.println("Passengers in priority order:");
        Iterator<Passenger> it = bookingQueue.iterator();
        while (it.hasNext()) {
            System.out.println(bookingQueue.poll());
        }
    }
}
