package thirtydayschallenge;

public class ReverseWordsinaString {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() -1;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ')
                start++;
            else
                break;
        }

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == ' ')
                end--;
            else
                break;
        }
        char[] a = s.toCharArray();
        for(int i=start; i<=end; i++) {
            if(a[i] != ' ') {
                sb.append(a[i]);
            }else if (a[i-1] != ' '){
                sb.append(a[i]);
            }
        }

        char[] b = sb.toString().toCharArray();
        swap(0 ,b.length-1, b);

        start = 0;
        end = 0;
        while(end < b.length) {
            if (end == b.length - 1) {
                swap(start, end, b);
                break;
            }

            if (b[end] != ' ') {
                end++;
            } else {
                swap(start, end - 1, b);
                end++;
                start = end;
            }
        }
        return new String(b);
    }

    private void swap (int l, int h, char[] c) {
        while(l < h) {
            char temp = c[l];
            c[l] = c[h];
            c[h] = temp;
            l++;
            h--;
        }
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(new ReverseWordsinaString().reverseWords(s1));
    }

}
