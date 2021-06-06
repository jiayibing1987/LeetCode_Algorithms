package contest;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinimumSpaceWastedFromPackaging {

    public int minWastedSpace(int[] packages, int[][] boxes) {
        long m = 1000000000 + 7;
        Arrays.sort(packages);
        long[] prefixSum  = new long[packages.length] ;
        long sum = 0;
        for(int i = 0; i < packages.length; i ++) {
            sum += packages[i];
            prefixSum[i] = sum;
        }

        TreeMap<Long, int[]> treeMap = new TreeMap<>();
        for(int i = 0; i < packages.length; i ++) {
            if(!treeMap.containsKey((long)packages[i])) {
                treeMap.put((long) packages[i], new int[] {i , i});
            } else {
                int[] value = treeMap.get((long)packages[i]);
                value[1] = i;
            }
        }

        int maxPackage = packages[packages.length - 1];
        long min = Long.MAX_VALUE;
        for(int[] supplier : boxes) {
            Arrays.sort(supplier);
            int maxBox = supplier[supplier.length - 1];
            if(maxBox < maxPackage) continue;
            long waste = 0;
            int fromIndex;
            int toIndex;
            for(int i = 0; i < supplier.length; i ++) {
                long curBox = supplier[i];
                if(i == 0) {
                    fromIndex = 0;
                } else {
                    long preBox = supplier[i - 1];
                    Map.Entry<Long, int[]> higher_entry = treeMap.higherEntry(preBox);
                    fromIndex = higher_entry == null ? - 1 : higher_entry.getValue()[0];
                }
                Map.Entry<Long, int[]> floor_entry = treeMap.floorEntry(curBox);
                toIndex = floor_entry == null ? -1 : treeMap.floorEntry(curBox).getValue()[1];

                if(toIndex < fromIndex || fromIndex == -1 || toIndex == -1) continue;
                long provided = curBox * (toIndex - fromIndex + 1);
                long usedSpaces = prefixSum[toIndex] - (fromIndex == 0 ? 0 : prefixSum[fromIndex - 1]);
                waste += provided - usedSpaces;
            }
            min = Math.min(waste, min);
        }

        if(min == Long.MAX_VALUE) return - 1;
        return (int)(min % m);
    }

    public static void main(String[] args) {
        MinimumSpaceWastedFromPackaging w = new MinimumSpaceWastedFromPackaging();
        int[] p1 = new int[] {2, 3, 5};
        int[][]b1 = new int[][] {{4,8}, {2,8}};
        //System.out.println(w.minWastedSpace(p1, b1));

        int[] p2 = new int[] {7,6,5,3,4};
        int[][] b2 = new int[][] {{2,7},{6},{10,5}};
        //System.out.println(w.minWastedSpace(p2, b2));

        int[] p3 = new int[100000] ;
        for(int i = 0; i < 100000; i ++)
            p3[i] = i + 1;
        int[][] b3 = new int[][]{{50000, 100000}};
        System.out.println(w.minWastedSpace(p3, b3));

    }
}
