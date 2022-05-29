package contest;

public class ApplyDiscounttoPrices {

    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] array = sentence.split(" ");
        for(String s : array) {
            if(!isPrice(s)) {
                sb.append(s);
            }else {
                long digits = Long.valueOf(s.substring(1));
                long temp = (long)((double)digits * (double)(100 - discount));
                sb.append("$");
                String value_String = postProcess(temp);
                sb.append(value_String);
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    private String postProcess(long v) {
        String value_String = String.valueOf(v);
        int n = value_String.length();
        if(n == 1) {
            return "0.0" + value_String;
        } else if (n == 2) {
            return "0." + value_String;
        } else {
            int index = n - 2;
            return value_String.substring(0, index) + "." + value_String.substring(index);
        }
    }

    private boolean isPrice(String s) {
        if(s.charAt(0) != '$' || s.length() <= 1)
            return false;
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '$')
                count ++;
            else if (!Character.isDigit(c))
                return false;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        ApplyDiscounttoPrices a = new ApplyDiscounttoPrices();
        System.out.println(a.discountPrices("$7651913186", 28));
    }
}
