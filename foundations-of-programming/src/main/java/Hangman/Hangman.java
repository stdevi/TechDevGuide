package Hangman;

import org.javatuples.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman {
    private static final String PATH = "C:\\Foo\\TechDevGuide\\foundations-of-programming\\src\\main\\java\\Hangman\\words.txt";
    private int guessesNum = 8;
    private List<String> words;
    private String word;
    private List<Pair<String, String>> wordLetters;

    private void initializeGame() {
        readFileWithWords();
        word = words.get(new Random().nextInt(words.size())).toUpperCase();
        wordLetters = new ArrayList<>();
        word.chars().forEach(letter -> wordLetters.add(new Pair<>(Character.toString(letter), "-")));
    }

    private String getWordLetters() {
        return wordLetters.stream().map(Pair::getValue1).collect(Collectors.joining());
    }

    private void makeGuess() {
        Scanner s = new Scanner(System.in);
        String letter = s.nextLine().toUpperCase();
        wordLetters = wordLetters.stream()
                .map(pair -> {
                    if (pair.getValue0().equals(letter)) {
                        return new Pair<>(pair.getValue0(), pair.getValue0());
                    }
                    return pair;
                })
                .collect(Collectors.toList());
        if (!getEncryptedLetters().contains(letter)) {
            guessesNum--;
        }
    }

    private void readFileWithWords() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH))) {
            words = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List getEncryptedLetters() {
        return wordLetters.stream().map(Pair::getValue1).collect(Collectors.toList());
    }

    public void startGame() {
        System.out.println("Welcome to Hangman!");
        initializeGame();
        while (guessesNum > 0) {
            if (!getEncryptedLetters().contains("-")) {
                System.out.println("You guessed the word: " + word);
                System.out.println("You win.");
                return;
            }
            System.out.println("The word now looks like this: " + getWordLetters());
            System.out.println("You have " + guessesNum + " guesses left.");
            System.out.print("Your guess: ");
            makeGuess();
        }
        System.out.println("The word was " + word);
        System.out.println("You lose.");
    }
}
