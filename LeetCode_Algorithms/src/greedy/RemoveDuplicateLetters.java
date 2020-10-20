package greedy;

import java.util.*;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 1) return s;
        int n = s.length();
        char[] charArray = s.toCharArray();
        char[] res = new char[n];
        Queue<Integer>[] charIndexQueues = new LinkedList[26];
        for(int i=0; i<26; i++)
            charIndexQueues[i] = new LinkedList<>();
        for(int i=0; i<n; i++) {
            char c = charArray[i];
            charIndexQueues[c - 'a'].add(i);
        }

        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< n; i++) {
            char c = charArray[i];
            if(set.contains(c)) { charIndexQueues[c - 'a'].poll(); continue;}
            while(!stack.isEmpty() && c < stack.peek() && charIndexQueues[stack.peek() - 'a'].size() > 1) {
                char removed = stack.pop();
                charIndexQueues[removed - 'a'].poll();
                set.remove(removed);
            }
            stack.push(c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main (String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.print(r.removeDuplicateLetters("bbcaac"));
    }
}
