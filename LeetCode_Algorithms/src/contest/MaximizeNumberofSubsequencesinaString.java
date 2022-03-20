package contest;

public class MaximizeNumberofSubsequencesinaString {

    public long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        long[] counts = new long[n];
        char c1 = pattern.charAt(0);
        char c2 = pattern.charAt(1);

        long second = 0;
        long first = 0;
        long sum = 0;
        for(int i = n - 1; i >= 0; i --) {
            if(c1 == c2) {
                if(text.charAt(i) == c1) {
                    sum += second;
                    second ++;
                }
            } else {
                if(text.charAt(i) == c2) {
                    second++;
                } else if(text.charAt(i) == c1) {
                    first ++;
                    sum += second;
                }
            }

        }

        if(c1 == c2)
            return sum + second;
        else {
            if(first > second )
                return sum + first;

            return sum + second;
        }
    }

    public static void main(String[] args) {
        MaximizeNumberofSubsequencesinaString m = new MaximizeNumberofSubsequencesinaString();
        System.out.println(m.maximumSubsequenceCount("aaa", "aa"));
        System.out.println(m.maximumSubsequenceCount("mffiqmrvjmkfmbnaivajzecfdta", "hh"));
    }
}
