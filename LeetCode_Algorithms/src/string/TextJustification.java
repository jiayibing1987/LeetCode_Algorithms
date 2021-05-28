package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0;
        while (left < words.length) {
            int right = findRightIndex(left, words, maxWidth);
            //generate line of words for index [left, right - 1]
            String line = generateALine(left, right - 1, words, maxWidth);
            res.add(line);
            //reset left to right position (next string to start searching right index)
            left = right;
        }
        return res;
    }

    private int findRightIndex(int left, String[] words, int maxWidth) {
        int right = left;
        int curLen = 0;
        while (right < words.length) {
            if (left == right) {
                if (words[right].length() > maxWidth) break;
                curLen += words[right].length();
            } else {
                if (curLen + words[right].length() + 1 > maxWidth) break;
                curLen += words[right].length() + 1;
            }
            right++;
        }
        return right;
    }

    private String generateALine(int left, int right, String[] words, int maxWidth) {
        String line;
        if (left == right || right == words.length - 1) {
            line = leftJustify(left, right, words, maxWidth);
        } else {
            line = equallyJustify(left, right, words, maxWidth);
        }
        return line;
    }

    //Science  is  what we//  max = 20 curLen = 15, number_of_spaces = 3, total_spaces = 5, space_base_length = 5 / 3 = 1, space_remain_length = 5 % 3 = 2
    private String equallyJustify(int left, int right, String[] words, int maxWidth) {
        //calc spaces
        int word_tota_lLength = 0;
        for (int i = left; i <= right; i++) {
            word_tota_lLength += words[i].length();
        }
        int number_of_spaces = right - left;
        int total_spaces = maxWidth - word_tota_lLength;
        int space_base_length = total_spaces / number_of_spaces;
        int space_remain_length = total_spaces % number_of_spaces;

        StringBuilder sb = new StringBuilder();
        int i = left;
        while (i <= right) {
            sb.append(words[i]);
            if (i != right) { // if not last words, add spaces after a word
                int space_length = space_remain_length-- > 0 ? space_base_length + 1 : space_base_length;
                sb.append(" ".repeat(space_length));
            }
            i++;
        }
        return sb.toString();
    }

    private String leftJustify(int left, int right, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int i = left;
        while (sb.length() < maxWidth) {
            //process words
            if (i <= right) {
                //if not first word append a space before word
                if (i != left) sb.append(" ");
                sb.append(words[i++]);
            } else { //process remain spaces
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TextJustification t = new TextJustification();
        String[] words1 = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(t.fullJustify(words1, 16));

        String[] words2 = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(t.fullJustify(words2, 16));

    }

}
