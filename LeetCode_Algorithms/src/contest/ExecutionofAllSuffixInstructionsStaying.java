package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExecutionofAllSuffixInstructionsStaying {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();

        int[] res = new int[m];
        for(int i = 0; i < m ; i ++) {
            String subStr = s.substring(i);
            int count = search(n, startPos, subStr);
            res[i] = count;
        }
        return res;
    }

    private int search (int n, int[] startPos, String s){
        int i = startPos[0];
        int j = startPos[1];
        int count = 0;

        for(char c : s.toCharArray()) {
            if(c == 'R') {
                j ++;
            } else if (c == 'L') {
                j --;
            } else if (c == 'U') {
                i --;
            } else if (c == 'D') {
                i ++;
            }

            if(i < 0 || i >= n || j < 0 || j >= n) {
                break;
            }
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        ExecutionofAllSuffixInstructionsStaying e = new ExecutionofAllSuffixInstructionsStaying();
        int[] r1 = e.executeInstructions(3, new int[] {0, 1}, "RRDDLU");
        System.out.println(Arrays.toString(r1));
    }
}
