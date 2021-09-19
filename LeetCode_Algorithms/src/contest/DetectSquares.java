package contest;

import util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {

    Map<Pair<Integer, Integer>, Integer> map;
    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        Pair<Integer, Integer> p = new Pair<>(x, y);
        map.put(p, map.getOrDefault(p, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0];
        int y = point[1];


        for(Map.Entry<Pair<Integer, Integer>, Integer> entry : map.entrySet()) {
            Pair<Integer, Integer> p = entry.getKey();
            int dx = p.getKey();
            int dy = p.getValue();
            if(dx == x || dy == y || Math.abs(dx - x) != Math.abs(dy - y)) {
                continue;
            } else {
                int countD = entry.getValue();
                int countX = map.getOrDefault(new Pair<>(x, dy), 0);
                int countY = map.getOrDefault(new Pair<>(dx, y), 0);
                res += countD * countX * countY;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
//        detectSquares.add(new int[] {0,0});
//        detectSquares.add(new int[] {8,0});
//        detectSquares.add(new int[] {8,8});
//        detectSquares.add(new int[] {8,0});
//
//        detectSquares.add(new int[] {1,8});
//        detectSquares.add(new int[] {9,8});
//        System.out.println( detectSquares.count(new int[] {0, 8}));
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        detectSquares.count(new int[] {11, 10}); // return 1. You can choose:
        //   - The first, second, and third points
        detectSquares.count(new int[] {14, 8});  // return 0. The query point cannot form a square with any points in the data structure.
        detectSquares.add(new int[] {11, 2});    // Adding duplicate points is allowed.
        System.out.println(detectSquares.count(new int[] {11, 10})); // return 2. You can choose:
        //   - The first, second, and third points
        //   - The first, third, and fourth points

    }
}
