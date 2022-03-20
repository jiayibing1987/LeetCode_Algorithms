package contest;

public class MinimumWhiteTilesAfterCoveringWithCarpets {

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[] array = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i ++) {
            if(floor.charAt(i) == '1') {
                array[i] ++;
                sum ++;
            }
        }

        while(numCarpets > 0 && sum > 0) {
            int cur = 0;
            for(int i = 0; i < carpetLen; i ++) {
                cur += array[i];
            }
            int max = cur;
            int maxStart = 0;
            int maxEnd = carpetLen - 1;

            for(int i = 0; i + carpetLen< n; i ++) {
                cur -= array[i];
                cur += array[i + carpetLen];
                if(cur >= max) {
                    maxStart = i + 1;
                    maxEnd = i + carpetLen;
                    max = cur;
                }
            }

            for(int i = maxStart; i <= maxEnd; i ++)
                array[i] = 0;

            sum -= max;
            numCarpets--;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumWhiteTilesAfterCoveringWithCarpets c = new MinimumWhiteTilesAfterCoveringWithCarpets();
//        System.out.println(c.minimumWhiteTiles("10110101", 2, 2));
//        System.out.println(c.minimumWhiteTiles("11111", 2, 3));
//        System.out.println(c.minimumWhiteTiles("11110", 1, 3));
        System.out.println(c.minimumWhiteTiles("101111", 2, 3));
    }
}
