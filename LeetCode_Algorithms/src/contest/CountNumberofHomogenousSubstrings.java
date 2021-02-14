package contest;

public class CountNumberofHomogenousSubstrings {

    public int countHomogenous(String s) {
        int n = s.length();
        int i= 0;
        long res = 0;
        double m = Math.pow(10, 9) + 7;
        for(int j = 1; j<n; j++) {
            if(s.charAt(i) != s.charAt(j)) {
                int length = j - i;
                i = j;
                res += calc(length);
            }
        }
        res += calc(n-i);
        return (int) (res % m);
    }

    private long calc (int x) {
        return (long) ((double)(1 + x) / 2.0 * x);
    }

    public static void main(String[] args) {
        CountNumberofHomogenousSubstrings c = new CountNumberofHomogenousSubstrings();
        System.out.println(c.countHomogenous("abbcccaa"));
        System.out.println(c.countHomogenous("zzzzz"));
        System.out.println(c.countHomogenous("xy"));
    }
}
