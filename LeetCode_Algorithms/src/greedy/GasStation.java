package greedy;

/**
 * 134. Gas Station
 * 
 * @author Ryan
 *
 */
public class GasStation {

	// gas = [1, 2, 3, 4, 5]
	// cost = [3, 4, 5, 1, 2]
	// curGas=[-2,-2,-2,6, 6] this mean if we start at a index, how much gas
	// when we left this station
	// iterate cur gas array, when find a postive value, see if can have enough
	// gas until next positive station
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0 || cost.length == 0)
			return -1;
		int sum = 0;
		int currentGas = 0;
		int startIndex = -1;
		for (int i = 0; i < gas.length; i++) {
			// first positive number that left gas station, gas is positive
			if (gas[i] - cost[i] >= 0 && currentGas <= 0) {
				startIndex = i;
				currentGas = gas[i] - cost[i];
			} else {
				currentGas += gas[i] - cost[i];
			}
			sum += gas[i] - cost[i];
		}
		return sum < 0 ? -1 : startIndex;
	}

	public static void main(String[] args) {
		GasStation g = new GasStation();
		int[] gas = { 3, 3, 4 };
		int[] cost = { 3, 4, 4 };
		System.out.print(g.canCompleteCircuit(gas, cost));
	}

}
