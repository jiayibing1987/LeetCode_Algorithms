package contest;

public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        int n = s.length();
        int odd0 = 0;
        int odd1 = 0;
        int even0 = 0;
        int even1 = 0;

        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                if(s.charAt(i) == '0')
                    even0 ++;
                else
                    even1++;
            }else{
                if(s.charAt(i) == '0')
                    odd0 ++;
                else
                    odd1++;
            }
        }
        //change all even index to 0, then all odd index to 1
        int result1 = even1 + odd0;
        //change all even index to 1, then all odd index to 0
        int result2 = even0 + odd1;
        return Math.min(result1, result2);
    }

}
