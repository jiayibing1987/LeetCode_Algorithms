package string;

public class ConstructStringWithRepeatLimit {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] counts = new int[26];
        for(char c: s.toCharArray()) {
            counts[c - 'a'] ++;
        }

        int primary = 25;
        int secondary;
        StringBuilder sb = new StringBuilder();

        int repeated = 0;
        while(primary >= 0) {
            if(repeated == repeatLimit) {
                secondary = primary - 1;
                //find the index of secondary number
                while(secondary >= 0 && counts[secondary] == 0) {
                    secondary--;
                }
                if(secondary < 0) break;
                sb.append((char)('a' + secondary));
                counts[secondary] --;
                repeated = 0;
            } else {
                //find the index of primary number
                while(primary >= 0 && counts[primary] == 0) {
                    primary--;
                    repeated = 0;
                }
                if(primary < 0) break;
                //int k = Math.min(repeatLimit, counts[primary]);
                //for(int i = 0; i < k; i ++) {
                sb.append((char)('a' + primary));
                counts[primary] --;
                repeated ++;
                //}
                if(counts[primary] == 0) repeated = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConstructStringWithRepeatLimit c = new ConstructStringWithRepeatLimit();
        //System.out.println(c.repeatLimitedString("cczazcc", 3));
        System.out.println(c.repeatLimitedString("aababab", 2));
        //System.out.println(c.repeatLimitedString("robnsdvpuxbapuqgopqvxdrchivlifeepy", 2));
    }
}
