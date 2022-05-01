package contest;

public class RemoveDigitFromNumbertoMaximizeResult {

    public String removeDigit(String number, char digit) {
        int lastIndex = number.lastIndexOf(digit);
        int n = number.length();
        int deleteIndex = -1;
        for(int i = 0; i < number.length(); i ++) {
            char c = number.charAt(i);
            if(c == digit) {
                if(i != n - 1 && number.charAt(i + 1) > c) {
                    deleteIndex = i;
                    break;
                }
            }
        }
        if(deleteIndex == -1) deleteIndex = lastIndex;
        StringBuilder sb = new StringBuilder(number);
        sb.deleteCharAt(deleteIndex);
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDigitFromNumbertoMaximizeResult r = new RemoveDigitFromNumbertoMaximizeResult();
        System.out.print(r.removeDigit("1231", '1'));
    }
}
