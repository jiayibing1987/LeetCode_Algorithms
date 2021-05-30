package contest;

public class MaximumValueafterInsertion {

    public String maxValue(String n, int x) {
        boolean isNegative = n.charAt(0) == '-';
        StringBuilder sb = new StringBuilder(n);
        int index = findIndex(n, x, isNegative);
        sb.insert(index, x);
        return sb.toString();
    }

    private int findIndex(String n, int x, boolean isNegative) {
        if(!isNegative) {
            for(int i = 0; i < n.length(); i++) {
                if(x > (n.charAt(i) - '0')){
                    return i;
                }
            }
            return n.length() ;
        } else {
            for(int i = 1; i < n.length(); i++) {
                if(x < (n.charAt(i) - '0')){
                    return i;
                }
            }
            return n.length() ;
        }
    }

    public static void main(String[] args) {
        MaximumValueafterInsertion m = new MaximumValueafterInsertion();
        System.out.println(m.maxValue("99", 9));
        System.out.println(m.maxValue("-132", 3));

    }
}
