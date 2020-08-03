package thirtydayschallenge;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();
        while(low < high) {
            char c1 = Character.toLowerCase(chars[low]);
            char c2 = Character.toLowerCase(chars[high]);
            if(!Character.isLetterOrDigit(c1)) {
                low ++;
            }else if(!Character.isLetterOrDigit(c1)) {
                high --;
            }else {
                if(c1!= c2)
                    return false;
                low ++;
                high --;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));
        System.out.println(Character.toLowerCase('A'));
    }
}
