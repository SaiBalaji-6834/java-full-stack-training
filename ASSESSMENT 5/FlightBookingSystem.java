package DAY6;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Flight {
    private String flightNumber;
    private LocalDateTime departureTime;
    private Duration duration;
    private double price;

    public Flight(String flightNumber, LocalDateTime departureTime, Duration duration, double price) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.duration = duration;
        this.price = price;
    }

    public String getFlightNumber() { return flightNumber; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public Duration getDuration() { return duration; }
    public double getPrice() { return price; }

    public void display() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm a");
        System.out.println(flightNumber + " | Departure: " + departureTime.format(formatter) + " | Duration: " 
            + duration.toHours() + " hrs | Price: $" + price);
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(
            new Flight("FL123", LocalDateTime.now().plusHours(3), Duration.ofHours(2), 150.0),
            new Flight("FL456", LocalDateTime.now().plusHours(8), Duration.ofHours(5), 200.0),
            new Flight("FL789", LocalDateTime.now().plusHours(1), Duration.ofHours(1), 120.0)
        );

        LocalDateTime now = LocalDateTime.now();

        // Flights departing in the next 6 hours
        List<Flight> upcomingFlights = flights.stream()
            .filter(f -> f.getDepartureTime().isAfter(now) && f.getDepartureTime().isBefore(now.plusHours(6)))
            .collect(Collectors.toList());

        // Cheapest flight
        Optional<Flight> cheapestFlight = flights.stream()
            .min(Comparator.comparing(Flight::getPrice));

        // Fastest flight
        Optional<Flight> fastestFlight = flights.stream()
            .min(Comparator.comparing(Flight::getDuration));

        // Display results
        System.out.println("Flights Departing in Next 6 Hours:");
        upcomingFlights.forEach(Flight::display);

        System.out.println("\nCheapest Flight:");
        cheapestFlight.ifPresent(Flight::display);

        System.out.println("\nFastest Flight:");
        fastestFlight.ifPresent(Flight::display);
    }
}
