package hashtable;

import java.util.*;

public class VowelSpellchecker {

    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] res = new String[n];
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> capitalization = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();

        //init two maps
        for(String word : wordlist) {
            capitalization.putIfAbsent(word.toLowerCase(), word);
            vowel.putIfAbsent(convertVowel(word).toLowerCase(), word);
        }

        //map queries to word list
        for(int i = 0; i < n; i++) {
            String query = queries[i];
            if(wordSet.contains(query)) {
                res[i] = query;
            } else if (capitalization.containsKey(query.toLowerCase())) {
                res[i] = capitalization.get(query.toLowerCase());
            } else {
                res[i] = vowel.getOrDefault(convertVowel(query).toLowerCase(), "");
            }
        }
        return res;
    }

    private String convertVowel (String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(vowels.contains(c))
                sb.append('a');
            else
                sb.append(c);
        }
        return sb.toString();
    }

}
