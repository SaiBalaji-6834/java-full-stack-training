package DAY6;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class Stock {
    private String symbol;
    private double price;
    private int volume;
    private LocalDateTime lastTradeTime;

    public Stock(String symbol, double price, int volume, LocalDateTime lastTradeTime) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.lastTradeTime = lastTradeTime;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public LocalDateTime getLastTradeTime() { return lastTradeTime; }

    public void display() {
        System.out.println(symbol + " | Price: $" + price + " | Last Trade: " + lastTradeTime);
    }
}

public class StockMarketAnalyzer {
    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(
            new Stock("AAPL", 175.5, 10000, LocalDateTime.now().minusHours(2)),
            new Stock("GOOGL", 2900.3, 5000, LocalDateTime.now().minusHours(25)),
            new Stock("TSLA", 750.8, 7000, LocalDateTime.now().minusHours(1))
        );

        // Highest-priced stock
        Optional<Stock> highestStock = stocks.stream()
            .max(Comparator.comparing(Stock::getPrice));

        // Average stock price
        double avgPrice = stocks.stream()
            .mapToDouble(Stock::getPrice)
            .average()
            .orElse(0.0);

        // Stocks traded in the last 24 hours
        List<Stock> recentStocks = stocks.stream()
            .filter(stock -> stock.getLastTradeTime().isAfter(LocalDateTime.now().minusHours(24)))
            .collect(Collectors.toList());

        System.out.println("Highest-Priced Stock:");
        highestStock.ifPresent(Stock::display);

        System.out.println("\nAverage Stock Price: $" + avgPrice);

        System.out.println("\nStocks Traded in the Last 24 Hours:");
        recentStocks.forEach(Stock::display);
    }
}
