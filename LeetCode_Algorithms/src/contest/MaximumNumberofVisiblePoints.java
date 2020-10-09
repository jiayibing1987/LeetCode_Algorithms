package contest;

import java.util.*;

public class MaximumNumberofVisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        TreeMap<Double, Integer> treeMap = new TreeMap<>();
        List<Double> angles = new ArrayList<>();
        boolean containsLocation = false;

        for(List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if(x == location.get(0) && y == location.get(1)) {
                containsLocation = true;
                continue;
            }
            angles.add(getAngle(x-location.get(0), y-location.get(1)));
        }

        Collections.sort(angles);
        for(int i=0; i<angles.size(); i++) {
            treeMap.put(angles.get(i), i);
        }

        int max = 0;
        for(int j=0; j<angles.size(); j++) {
            double cur_angle = angles.get(j);
            double max_angle = cur_angle + angle;
            int numberOfPoints;
            if(max_angle < 360) {
                Map.Entry<Double, Integer> entry = treeMap.floorEntry(max_angle);
                numberOfPoints = entry.getValue() - j + 1;
            } else {
                numberOfPoints = angles.size() - j;
                Map.Entry<Double, Integer> entry = treeMap.floorEntry(max_angle-360);
                if(entry != null)
                     numberOfPoints += entry.getValue() - 0 + 1;
            }
            max = Math.max(numberOfPoints, max);
        }
        return containsLocation ? max+1 : max;
    }

    public double getAngle(int x, int y) {
        double angle =  Math.toDegrees(Math.atan2(y, x));

        if(angle < 0d){
            angle += 360d;
        }

        return angle;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(3);
        l3.add(3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(4);
        List<List<Integer>> points = new ArrayList<>();
        points.add(l1);
        points.add(l2);
        points.add(l3);
        points.add(l4);

        MaximumNumberofVisiblePoints m = new MaximumNumberofVisiblePoints();
        System.out.println(m.visiblePoints(points, 0, new ArrayList<>(l1)));
    }
}