package sort;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> res = mergeSort(buildings, 0, n-1);
        return res;
    }

    private List<List<Integer>> mergeSort(int[][] buildings, int low, int high) {
        List<List<Integer>> mergedList = new ArrayList<>();
        if(low == high) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(buildings[low][0]); temp1.add(buildings[low][2]);
            List<Integer> temp2 = new ArrayList<>();
            temp2.add(buildings[low][1]); temp2.add(0);
            mergedList.add(temp1);
            mergedList.add(temp2);
            return mergedList;
        }

        if(low < high) {
            int mid = low + (high - low) / 2;
            List<List<Integer>> leftList = mergeSort(buildings, low, mid);
            List<List<Integer>> rightList = mergeSort(buildings, mid + 1, high);
            mergedList = mergeLists(leftList, rightList);
        }

        return mergedList;
    }

    private List<List<Integer>> mergeLists(List<List<Integer>> leftList, List<List<Integer>> rightList) {
        List<List<Integer>> mergedList = new ArrayList<>();
        int p1 = 0, p2 = 0;
        int leftY = 0, rightY = 0, curY = 0, x = 0;
        while(p1 < leftList.size() && p2 < rightList.size()) {
            List<Integer> pointL = leftList.get(p1);
            List<Integer> pointR = rightList.get(p2);

            if(pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                p1++;
            } else {
                x= pointR.get(0);
                rightY = pointR.get(1);
                p2++;
            }
            int newY = Math.max(leftY, rightY);
            if(newY != curY) {
                curY = newY;
                addPoint(mergedList, x, newY);
            }
        }

        appendSkyline(mergedList, leftList, p1, leftList.size(), curY);
        appendSkyline(mergedList, rightList, p2, rightList.size(), curY);

        return mergedList;
    }

    public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
                              int p, int n, int currY) {
        while (p < n) {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;

            // update output
            // if there is a skyline change
            if (currY != y) {
                addPoint(output, x, y);
                currY = y;
            }
        }
    }

    private void addPoint(List<List<Integer>> list, int x, int newY) {

        if(list.isEmpty() || list.get(list.size() - 1).get(0) != x) {
            List<Integer> temp = new ArrayList<>();
            temp.add(x); temp.add(newY);
            list.add(temp);
        } else {
            list.get(list.size() - 1).set(1, newY);
        }
    }

}
