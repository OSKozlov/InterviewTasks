package com.interview.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Game (String publisher, String title, String genre) {}

record Box (List<Game> games) {}

public class InterviewTask3 {

    public static void main(String[] args) {

        // Create a list of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // Process the names in a stream
        long size = names.stream()
                .filter(s -> s.length() > 1)
                .peek(name -> System.out.println("name: " + name)) // Log input
                .map(String::toUpperCase) // Convert each name to uppercase
                .peek(name -> System.out.println("Uppercase name: " + name)) // Log intermediate results
                .count(); // Get the size of the resulting list

        // Print the size of the resulting array
        System.out.println("Size of the array: " + size);


        var knownPublisher = List.of("Larian", "Microsoft", "Blizzard", "Activision");
        //1. update Microsoft -> MCRSFT

//        Function<String, String> function = (String s) -> {
//            return s.equals("Microsoft") ? "MCRSFT" : s;
//        };
        knownPublisher.stream().map(s -> s.equals("Microsoft") ? "MCRSFT" : s).forEach(System.out::println);

        var games = new ArrayList<Game>();
        games.add(new Game("Larian", "Baldurs Gate 3", "RPG"));
        games.add(new Game("Larian", "Divinity", "RPG"));
        games.add(new Game("MCRSFT", "Age of Empires 4", "RTS"));
        games.add(new Game("MCRSFT", "Age of Empires 3", "RTS"));
        games.add(new Game("MCRSFT", "Age of Empires 2", "RTS"));
        games.add(new Game("Blizzard", "WarCraft I", "RTS"));
        games.add(new Game("Blizzard", "WarCraft II", "RTS"));
        games.add(new Game("Blizzard", "WoW Classic", "MMORPG"));

        var box = new Box(games);

        var gamesFromBox = box.games();


        gamesFromBox.stream().collect(Collectors.groupingBy(Game::publisher, Collectors.counting())).forEach((K, V) -> System.out.println(K + " " + V));

        // 1. Print all publishers and the number of games in the box
        System.out.println("\nPublishers games count in the box:");

        gamesFromBox.stream()
                .collect(Collectors.groupingBy(Game::publisher, Collectors.counting()))
                .forEach((K,V) -> System.out.println("Publisher = " + K + "  number = " + V));


        // 2. Print the publisher games count in the box by genre
        System.out.println("\nPublisher games count by genre:");

        gamesFromBox.stream()
                .collect(Collectors.groupingBy(Game::genre, Collectors.counting()))
                .forEach((K,V) -> System.out.println("Genre = " + K + "  number = " + V));
    }
}
