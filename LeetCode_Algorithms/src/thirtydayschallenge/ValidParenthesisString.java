package thirtydayschallenge;

/**
 * 678. Valid Parenthesis String
 *
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low --;
                high --;
            } else if (c == '*') {
                low --;
                high ++;
            } else { //c = )
                low ++;
                high ++;
                if(high > 0) high = 0;
                if(low > 0) return false;
            }
        }
        return low <=0 && high >= 0;
    }

    public static void main(String[] args) {
        // "((*)(*))((*"
        System.out.println(new ValidParenthesisString().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

}
