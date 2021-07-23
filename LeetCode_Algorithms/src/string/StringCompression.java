package string;

public class StringCompression {

    public int compress(char[] chars) {
        int n = chars.length;
        int p = 0;
        int count = 1;
        char pre = chars[0];
        for(int i = 1; i <= n; i++) {
            char cur = i == n ? ' ' : chars[i];
            if(cur != pre) {
                chars[p++] = pre;
                String count_string = String.valueOf(count);
                for(char digit : count_string.toCharArray()) {
                    chars[p++] = digit;
                }
                count = 1;
            }else {
                count ++;
            }
        }
        return p;
    }
}
