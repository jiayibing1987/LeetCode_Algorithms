package string;

public class CountandSay {

    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i<n; i++) {
            res = helper(res);
        }
        return res;
    }

    private String helper(String s) {
        char[] chars = s.toCharArray();
        char cur = chars[0];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            if(c == cur) {
                count ++;
            }else {
                sb.append(count);
                sb.append(cur);
                cur = c;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }

    public static void main (String[] args) {
        CountandSay c = new CountandSay();
        System.out.println(c.countAndSay(4));
    }
}
