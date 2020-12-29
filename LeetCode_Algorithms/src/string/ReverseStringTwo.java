package string;

public class ReverseStringTwo {

    public String reverseStr(String s, int k) {
        if(s == null || s.isEmpty() || k<= 1)
            return s;
        char[] chars = s.toCharArray();
        int n = s.length();

        int i = 0;
        while(i < n) {
            int j = i+k-1;
            if(j >= n) j = n-1;
            reverse(chars, i, j);
            i += 2*k;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while(i<j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
