package twopointer;

public class ValidPalindromeTwo {

    public boolean validPalindrome(String s) {
        int n = s.length();
        int low = 0;
        int high = n - 1;

        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                boolean r1 =  isPalindrome(s, low + 1, high);
                boolean r2 = isPalindrome(s, low, high - 1);
                return r1 || r2;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            }else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeTwo v = new ValidPalindromeTwo();
        System.out.println(v.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
