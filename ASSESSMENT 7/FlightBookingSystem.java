package DAY8;

import java.util.*;
import java.util.concurrent.*;

class Flight {
    String flightNumber;
    int seats;
    Flight(String flightNumber, int seats) { this.flightNumber = flightNumber; this.seats = seats; }
}

class FlightBookingSystem {
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);
    private static final Map<String, Flight> flights = new HashMap<>();
    
    static {
        flights.put("A101", new Flight("A101", 10));
    }
    
    static Future<List<Flight>> searchFlights() {
        return executor.submit(() -> new ArrayList<>(flights.values()));
    }
    
    static synchronized boolean bookTicket(String flightNumber) {
        Flight flight = flights.get(flightNumber);
        if (flight != null && flight.seats > 0) {
            flight.seats--;
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        Future<List<Flight>> future = searchFlights();
        System.out.println("Available Flights: " + future.get());
        System.out.println("Booking A101: " + bookTicket("A101"));
        executor.shutdown();
    }
}
