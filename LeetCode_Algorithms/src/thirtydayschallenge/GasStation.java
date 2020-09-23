package thirtydayschallenge;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0)
			return -1;
        int n = gas.length;

        int sum_gas = 0;
        int sum_cost = 0;
        for(int i=0; i<n; i++) {
            sum_gas += gas[i];
            sum_cost = cost[i];
        }
        if(sum_gas < sum_cost) return -1;

        int cur_gas = 0;
        int startIndex = -1;
        for(int i=0; i<n; i++) {
            cur_gas += gas[i] - cost[i];
            if(cur_gas < 0) {
                cur_gas = 0;
                startIndex = -1;
            }else {
                if(startIndex == -1 && gas[i] >= cost[i])
                    startIndex = i;
            }
        }

        return startIndex;
    }

}

