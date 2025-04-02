package DAY6;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Movie {
    private String title;
    private String genre;
    private double rating;
    private LocalDate releaseDate;

    public Movie(String title, String genre, double rating, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public LocalDate getReleaseDate() { return releaseDate; }

    public void display() {
        System.out.println(title + " | " + genre + " | Rating: " + rating + " | Released: " + releaseDate);
    }
}

public class MovieRecommendation {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Sci-Fi", 8.8, LocalDate.of(2010, 7, 16)),
            new Movie("The Dark Knight", "Action", 9.0, LocalDate.of(2008, 7, 18)),
            new Movie("Interstellar", "Sci-Fi", 8.6, LocalDate.of(2014, 11, 7)),
            new Movie("Joker", "Drama", 8.5, LocalDate.of(2019, 10, 4))
        );

        // Sort movies by rating (desc) and release date (newest first)
        List<Movie> sortedMovies = movies.stream()
            .sorted(Comparator.comparing(Movie::getRating).reversed()
                .thenComparing(Movie::getReleaseDate).reversed())
            .collect(Collectors.toList());

        // Filter movies with rating > 8.0 and specific genre
        List<Movie> sciFiMovies = movies.stream()
            .filter(m -> m.getRating() > 8.0 && m.getGenre().equalsIgnoreCase("Sci-Fi"))
            .collect(Collectors.toList());

        // Get a top-rated random movie using Optional
        Optional<Movie> topMovie = movies.stream()
            .max(Comparator.comparing(Movie::getRating));

        System.out.println("Sorted Movies:");
        sortedMovies.forEach(Movie::display);

        System.out.println("\nSci-Fi Movies with Rating > 8.0:");
        sciFiMovies.forEach(Movie::display);

        System.out.println("\nTop Movie Recommendation:");
        topMovie.ifPresent(Movie::display);
    }
}
