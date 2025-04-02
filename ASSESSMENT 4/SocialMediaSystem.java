package DAY5;

import java.util.*;

class User {
    private String username;
    private HashSet<String> followers = new HashSet<>();

    public User(String username) {
        this.username = username;
    }

    public void addFollower(String follower) {
        followers.add(follower);
    }

    public TreeSet<String> getAlphabeticalFollowers() {
        return new TreeSet<>(followers);
    }

    public Set<String> suggestFriends(User other) {
        Set<String> suggestions = new HashSet<>(followers);
        suggestions.removeAll(other.followers);
        return suggestions;
    }

    @Override
    public String toString() {
        return username + "'s followers: " + followers;
    }
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        User alice = new User("Alice");
        alice.addFollower("Bob");
        alice.addFollower("Charlie");

        User bob = new User("Bob");
        bob.addFollower("Alice");
        bob.addFollower("Dave");

        System.out.println("Alice's followers (alphabetical):");
        alice.getAlphabeticalFollowers().forEach(System.out::println);

        System.out.println("\nFriend suggestions for Bob from Alice:");
        System.out.println(alice.suggestFriends(bob));
    }
}
