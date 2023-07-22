package org.jackkkonggg.medium;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortVowelsInString {
    private static final Set<Character> VOWELS =
            Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').collect(Collectors.toSet());

    public String sortVowels(String s) {
        List<Character> sortedVowels =
                s.chars().mapToObj(c -> (char) c).filter(VOWELS::contains).sorted().toList();

        StringBuilder sb = new StringBuilder();
        int sv = 0;
        for (char c : s.toCharArray())
            if (VOWELS.contains(c)) sb.append(sortedVowels.get(sv++));
            else sb.append(c);

        return sb.toString();
    }
}
