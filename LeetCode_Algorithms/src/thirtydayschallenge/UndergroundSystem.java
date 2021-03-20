package thirtydayschallenge;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    Map<Integer, Object[]> customers;
    Map<String, int[]> stations;

    public UndergroundSystem() {
        customers = new HashMap<>();
        stations = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!customers.containsKey(id)) {
            customers.put(id, new Object[] {stationName, t});
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(customers.containsKey(id)) {
            Object[] customerCheckInInfo = customers.get(id);
            String stationsStartToEnd = customerCheckInInfo[0] + " " + stationName;
            int travelTime = t - (int)customerCheckInInfo[1];
            if (!stations.containsKey(stationsStartToEnd)) {
                stations.put(stationsStartToEnd, new int[] {1, travelTime});
            } else {
                int[] countAndTotalTime = stations.get(stationsStartToEnd);
                countAndTotalTime[0] += 1;
                countAndTotalTime[1] += travelTime;
                stations.put(stationsStartToEnd, countAndTotalTime);
            }
            customers.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] countAndTotalTime =  stations.get(startStation + " " + endStation);
        if(countAndTotalTime == null) return 0;
        return (double)countAndTotalTime[1] / (double)countAndTotalTime[0];
    }
}
