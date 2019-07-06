package longest_word;

import org.javatuples.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class LongestWord {

    public String findLongestWord(String string, List<String> dictionary) {
        Map<Character, List<Pair<String, Integer>>> map = new HashMap<>();
        List<Pair<String, Integer>> founds = new ArrayList<>();

        dictionary.forEach(word -> {
            map.computeIfAbsent(word.charAt(0), l -> new ArrayList<>());
            map.get(word.charAt(0)).add(new Pair<>(word, 0));
        });

        string.chars().mapToObj(c -> (char) c).filter(map::containsKey).forEach(c -> {
            map.put(c, map.get(c).stream().map(pair -> pair = pair.setAt1(pair.getValue1() + 1)).collect(Collectors.toList()));

            Map<Character, List<Pair<String, Integer>>> toAdd = new HashMap<>();
            Map<Character, List<Pair<String, Integer>>> toRemove = new HashMap<>();

            map.get(c).stream().filter(pair -> pair.getValue1().equals(pair.getValue0().length())).forEach(founds::add);
            map.get(c).stream().filter(pair -> !pair.getValue1().equals(pair.getValue0().length())).forEach(pair -> {
                char nextWordLetter = pair.getValue0().charAt(pair.getValue1());
                map.computeIfAbsent(nextWordLetter, l -> new ArrayList<>());
                toAdd.computeIfAbsent(nextWordLetter, l -> new ArrayList<>()).add(pair);
            });
            map.get(c).forEach(pair -> toRemove.computeIfAbsent(c, l -> new ArrayList<>()).add(pair));

            toRemove.forEach((key, listOfPairs) -> map.get(key).removeAll(listOfPairs));
            toAdd.forEach((key, listOfPairs) -> map.get(key).addAll(listOfPairs));
        });

        return founds.stream().max(Comparator.comparingInt(Pair::getValue1)).map(Pair::getValue0).orElseThrow(NoSuchElementException::new);
    }
}