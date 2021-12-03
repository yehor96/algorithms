package com.yehor.charinword;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class CharUtil {

    private final Map<String, Map<Character, Integer>> cachedWords = new HashMap<>();

    /**
     * Get number of times a char occurs in a word. Uses cache to avoid processing the same request twice.
     * @param string word in which a char will be searched.
     * @param searched char to search.
     * @return number of times the char occurs in a word.
     */
    public int getOccurrences(String string, char searched) {
        return getExisted(string, searched)
                .orElseGet(() -> findOccurrences(string, searched));
    }

    private int findOccurrences(String string, char searched) {
        int counter = 0;
        for (char character : string.toCharArray()) {
            if (character == searched) {
                counter++;
            }
        }
        cache(string, searched, counter);
        return counter;
    }

    private void cache(String string, char searched, int occurrences) {
        Map<Character, Integer> wordMap = cachedWords.get(string);
        if (Objects.isNull(wordMap)) {
            wordMap = new HashMap<>();
        }

        wordMap.put(searched, occurrences);
        cachedWords.put(string, wordMap);
    }

    private Optional<Integer> getExisted(String string, char searched) {
        Map<Character, Integer> charMap = cachedWords.get(string);
        if (Objects.isNull(charMap)) {
            return Optional.empty();
        }

        Integer occurrences = charMap.get(searched);
        return Optional.ofNullable(occurrences);
    }

}
