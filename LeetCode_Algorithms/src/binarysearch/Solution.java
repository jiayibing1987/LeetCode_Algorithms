package binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/**
 * 497. Random Point in Non-overlapping Rectangles
 */
public class Solution {
    TreeMap<Integer, Integer> map;
    int size;
    int[][] rects;
    public Solution(int[][] rects) {
        map = new TreeMap<>();
        this.rects = rects;
        //rects[i] = [x1,y1,x2,y2]
        for(int i=0; i<rects.length; i++) {
            int[] rect = rects[i];
            map.put(size, i);
            size += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
        }
    }

    public int[] pick() {
        int ran = new Random().nextInt(size);
        int floorKey = map.floorKey(ran);
        int i = map.get(floorKey);
        int nth = ran - floorKey;
        return getCoordinate(rects[i], nth);
    }

    private int[] getCoordinate (int[] rect, int nth) {
        int x_length = rect[2] - rect[0] + 1;
        int y = nth / x_length;
        int x = nth % x_length;
        return new int[] {rect[0] + x, rect[1] + y};
    }

    public static void main(String[] args) {
        int[][] a = {{-2, -2, -1, -1}, {1, 0, 3, 0}};
        Solution s = new Solution(a);
        System.out.print(Arrays.toString(s.pick()));
        System.out.print(Arrays.toString(s.pick()));
        System.out.print(Arrays.toString(s.pick()));
        System.out.print(Arrays.toString(s.pick()));
        System.out.print(Arrays.toString(s.pick()));
    }

}
