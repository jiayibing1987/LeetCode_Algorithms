package contest;

import java.util.HashMap;
import java.util.Map;

public class DecodetheMessage {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int count = 0;
        for(char c : key.toCharArray()) {
            if(count == 26)
                break;
            if(c == ' ' || map.containsKey(c)) continue;

            map.put(c, (char)('a' + count));
            count ++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : message.toCharArray()) {
            if(c == ' ') sb.append(' ');
            else {
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodetheMessage d = new DecodetheMessage();
        System.out.println(d.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

}
