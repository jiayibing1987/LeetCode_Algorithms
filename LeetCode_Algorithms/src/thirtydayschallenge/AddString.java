package thirtydayschallenge;

public class AddString {

    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(; p1 >= 0 || p2 >= 0 || carry > 0; p1 --, p2 --) {
            int c1 = p1 < 0 ? 0 : num1.charAt(p1) - '0';
            int c2 = p2 < 0 ? 0 : num2.charAt(p2) - '0';
            int cur = c1 + c2 + carry;
            carry = cur >= 10 ? 1 : 0;
            sb.append(cur % 10);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddString a = new AddString();
        System.out.println(a.addStrings("11", "123"));
    }
}
