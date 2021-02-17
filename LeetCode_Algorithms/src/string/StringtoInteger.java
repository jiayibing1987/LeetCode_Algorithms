package string;

public class StringtoInteger {

    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int i = 0;
        //remove leading white spaces
        while (i < s.length() && s.charAt(i) == ' ')
            i++;
        if(i == s.length()) return 0;

        //detect if negative
        boolean isNegative = false;
        if (s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        //detect if not start with digit
        if (i == s.length() || !Character.isDigit(s.charAt(i))) {
            return 0;
        }

        //remove leading 0
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        //read digits
        StringBuilder sb = new StringBuilder();
        int value = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int d = Character.getNumericValue(s.charAt(i));
            if(!isNegative &&
                    (value > Integer.MAX_VALUE / 10 ||
                            (value == Integer.MAX_VALUE / 10 && d >= Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }else if(isNegative &&
                    (value * -1 < Integer.MIN_VALUE / 10 ||
                            (value * -1 == Integer.MIN_VALUE / 10 && d>= Integer.MIN_VALUE % 10 * -1))) {
                return Integer.MIN_VALUE;
            } else
                value = value * 10 + d;
            i++;
        }

        return isNegative ? value * -1 : value;
    }

    public static void main(String[] args) {
        StringtoInteger st = new StringtoInteger();
        System.out.println(st.myAtoi("-2147483647"));
    }
}
