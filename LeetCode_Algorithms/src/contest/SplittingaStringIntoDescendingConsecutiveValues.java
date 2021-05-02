package contest;

public class SplittingaStringIntoDescendingConsecutiveValues {

    public boolean splitString(String s) {
        int length = s.length();
        long num = 0;

        for (int i = 0; i < length - 1; i++) {
            //get the starting number of string
            num = num * 10 + (s.charAt(i)-'0');
            //next number is expected to be cur number - 1
            long expected = num - 1;
            long next_num = 0;

            //keep appending next character and comparing with the expected next Consecutive number
            for(int nextEnd = i+1; nextEnd < length; nextEnd++) {
                next_num = next_num * 10 + (s.charAt(nextEnd)-'0');
                if (next_num == expected) {
                    if(nextEnd == length - 1) return true;
                    next_num = 0;
                    expected = expected > 0 ? expected -1 : 0; //for edge case "100000" split into [1, 0],
                                                                // expected number can't go negative
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplittingaStringIntoDescendingConsecutiveValues sp = new SplittingaStringIntoDescendingConsecutiveValues();
/*        System.out.println(sp.splitString("050043"));
        System.out.println(sp.splitString("9080701"));
        System.out.println(sp.splitString("10009998"));*/
        System.out.println(sp.splitString("200100"));
    }
}
