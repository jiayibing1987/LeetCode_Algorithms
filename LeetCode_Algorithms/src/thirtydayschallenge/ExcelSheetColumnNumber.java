package thirtydayschallenge;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int res = 0;
        char[] chars = s.toCharArray();

        int exp = 0;
        for(int i=chars.length-1; i >=0; i--) {
            int number = convert(chars[i]);
            res += number * (int)Math.pow(26, exp);
            exp++;
        }
        return res;
    }

    private int convert(char c) {
        return (c - 'A') + 1;
    }
}
