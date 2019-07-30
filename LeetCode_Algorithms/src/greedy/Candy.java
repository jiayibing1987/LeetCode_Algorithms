package greedy;

import java.util.Arrays;

/**
 * #135
 * There are N children standing in a line. Each child is assigned a rating value.

 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * @author Ryan
 *
 */
public class Candy {

	public int candy(int[] ratings) {
		if (ratings.length == 0)
			return 0;
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		int sum = 0;

		for (int i = 1; i < ratings.length; i++) {
			if(ratings[i]>ratings[i-1])
				candy[i] = candy[i-1]+1;
		}
		
		for (int i = ratings.length-2; i >=0; i--) {
			if(ratings[i]>ratings[i+1] && candy[i]<=candy[i+1]){
				/* like /\ shape and this is a peak point */
				if(i>0 && ratings[i]>ratings[i-1]){
					candy[i] = Math.max(candy[i], candy[i+1])+1;
				}else{/* like \shape, ignore i-1 position, and increment i+1*/ 
					candy[i] = candy[i+1]+1;
				}
			}
			sum += candy[i];
		}
		return sum+candy[ratings.length - 1];
	}

	public static void main(String[] args) {
		Candy c = new Candy();
		int[] a = {1,0,2};
		System.out.println(c.candy(a));
	}
	
	// 1. brute force
	// o(n2)
	public int candy1(int[] ratings) {
		if (ratings.length == 0)
			return 0;
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for (int i = 0; i < ratings.length; i++) {
			for (int j = 0; j < ratings.length; j++) {
				if (j > 0 && (ratings[j] > ratings[j - 1] && candy[j] <= candy[j - 1]))
					candy[j] = candy[j - 1] + 1;
				if (j < ratings.length - 1 && (ratings[j] > ratings[j + 1] && candy[j] <= candy[j + 1]))
					candy[j] = candy[j + 1] + 1;
			}
		}
		int sum = 0;
		for (int n : candy)
			sum += n;
		return sum;
	}

}
