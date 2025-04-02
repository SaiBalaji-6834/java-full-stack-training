package DAY5;

import java.util.*;

class Bid implements Comparable<Bid> {
    private String bidder;
    private double amount;
    private long timestamp;

    public Bid(String bidder, double amount) {
        this.bidder = bidder;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Bid other) {
        // Higher amount first; if equal, earlier timestamp wins
        int amountCompare = Double.compare(other.amount, this.amount);
        return amountCompare != 0 ? amountCompare : 
               Long.compare(this.timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return bidder + " bid $" + amount + " at " + timestamp;
    }
}

class Auction<T> {  // Generic auction item type
    private T item;
    private PriorityQueue<Bid> bids = new PriorityQueue<>();

    public Auction(T item) {
        this.item = item;
    }

    public void placeBid(Bid bid) {
        bids.offer(bid);
    }

    public Bid processHighestBid() {
        return bids.poll();
    }
}

public class OnlineAuctionSystem {
    public static void main(String[] args) {
        Auction<String> paintingAuction = new Auction<>("Mona Lisa");
        paintingAuction.placeBid(new Bid("Alice", 5000));
        paintingAuction.placeBid(new Bid("Bob", 6000));
        paintingAuction.placeBid(new Bid("Charlie", 5000));  // Tie-breaker: earlier bid wins

        System.out.println("Highest bid: " + paintingAuction.processHighestBid());
    }
}
