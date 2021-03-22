package string;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for(int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if(c == '1' || c == '0' || c == '8')
                sb.append(c);
            else if(c == '6') {
                sb.append(9);
            } else if (c == '9') {
                sb.append(6);
            } else {
                return false;
            }
        }
        return num.equals(sb.toString());
    }

    public static void main(String[] args) {
        StrobogrammaticNumber s = new StrobogrammaticNumber();
        System.out.println(s.isStrobogrammatic("181"));
    }
}
