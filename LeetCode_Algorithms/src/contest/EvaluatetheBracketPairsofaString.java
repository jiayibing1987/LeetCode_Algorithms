package contest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluatetheBracketPairsofaString {

    public String evaluate(String s, List<List<String>> knowledge) {
        //init a map
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder keySB = null;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                keySB = new StringBuilder();
            } else if (c == ')') {
                String value = map.getOrDefault(keySB.toString(), "?");
                sb.append(value);
                keySB = null;
            } else {
                if (keySB != null)
                    keySB.append(c);
                else
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EvaluatetheBracketPairsofaString e = new EvaluatetheBracketPairsofaString();
    }
}
