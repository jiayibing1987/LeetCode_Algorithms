package bitmanipulation;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int p1 = c1.length-1;
        int p2 = c2.length-1;
        int carry = 0;

        while(p1 >= 0 || p2 >= 0 || carry != 0) {
            int v1 = p1 < 0 ? 0 : Character.getNumericValue(c1[p1]);
            int v2 = p2 < 0 ? 0 : Character.getNumericValue(c2[p2]);
            int sum = v1 + v2 + carry;
            sb.insert(0, sum %2);
            carry = sum >= 2 ? 1 : 0;
            p1--;
            p2--;
        }
        return sb.toString();
    }

}
