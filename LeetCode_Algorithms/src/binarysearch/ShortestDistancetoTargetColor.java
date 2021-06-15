package binarysearch;

import java.util.*;

public class ShortestDistancetoTargetColor {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < colors.length; i ++) {
            if(!map.containsKey(colors[i])) {
                map.put(colors[i], new ArrayList<>());
            }
            map.get(colors[i]).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for(int[] query : queries) {
            List<Integer> l = map.get(query[1]);
            int nearestIndex = binarySearch1(l, query[0]);
            if(nearestIndex != -1)
                res.add(Math.abs(nearestIndex - query[0]));
            else
                res.add(-1);
        }
        return res;
    }

    private int binarySearch1(List<Integer> list, int target) {
        if(list == null || list.size() == 0) return -1;
        if(list.size() == 1) return list.get(0);

        int l = 0, h = list.size() - 1;
        //find the insertion index of target
        while(l <= h) {
            int mid = (l + h) / 2;
            if(list.get(mid) == target) return list.get(mid);
            if(list.get(mid) < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        int res = l;

        if(res == 0)
            return list.get(0);
        else if (res >= list.size())
            return list.get(list.size() - 1);
        else {
            if (Math.abs(list.get(res - 1) - target) < Math.abs(list.get(res) - target))
                return list.get(res - 1);
            return list.get(res);
        }
    }

    private int binarySearch(List<Integer> list, int target) {
        if(list == null || list.size() == 0) return -1;
        if(list.size() == 1) return list.get(0);

        int l = 0, h = list.size() - 1;
        //find the first number which larger than target
        while(l < h) {
            int mid = (l + h) / 2;
            if(list.get(mid) == target) return list.get(mid);
            if(list.get(mid) < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        int res = l;

        if(res - 1 >= 0 && Math.abs(list.get(res - 1) - target) < Math.abs(list.get(res) - target))
            return list.get(res - 1);
        return list.get(res);
    }
}
