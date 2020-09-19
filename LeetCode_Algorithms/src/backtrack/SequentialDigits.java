package backtrack;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    List<Integer> results;
    public List<Integer> sequentialDigits(int low, int high) {
        results = new ArrayList<>();
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();
        for(int i=lowLength; i<=highLength; i++)
            backTrack( 1, i, low, high);
        return results;
    }

    private void backTrack(int startDigit, int length, int low, int high) {
        if(startDigit+length-1 > 9) return;
        StringBuilder sb = new StringBuilder();
        for(int i=startDigit; i<=startDigit+length-1; i++) {
            sb.append(i);
        }
        long value = Long.valueOf(sb.toString());

        if(value <= high ) {
            if (value >= low)
                results.add((int) value);
            backTrack(startDigit + 1, length, low, high);
        }
    }

}
