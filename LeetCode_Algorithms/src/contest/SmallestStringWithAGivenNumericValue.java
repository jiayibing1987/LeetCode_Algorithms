package contest;

public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {
        int remainChar = n;
        int left = k;

        int[] res = new int[n];

        for(int i=0; i<n; i++){
            int x = (remainChar - 1) * 26;
            if(x >= k) {
                res[i] = 1;
                k -= 1;
            } else {
                res[i] = k - x;
                k -= res[i];
            }
            remainChar--;
        }

        StringBuilder sb = new StringBuilder();
        for(int v : res)
            sb.append((char)('a' + v - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestStringWithAGivenNumericValue s = new SmallestStringWithAGivenNumericValue();
        System.out.println(s.getSmallestString(3, 27));
        System.out.println(s.getSmallestString(5, 73));

    }
}
