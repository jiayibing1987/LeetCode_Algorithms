package math;

import java.util.Arrays;

/**
 * #204. Count the number of prime numbers less than a non-negative number, n.
 * @author Ryan
 *
 */
public class CountPrimes {

	//brute force
    public int countPrimes1(int n) {
    	int count = 0;
    	loop1: for(int i = 2; i<n; i++){
    		for(int j=i; j<n; j++){
    			if(i%j==0 && i!=j)
    				continue loop1;
    		}
    		count++;
    	}
    	return count;
    }
    
    //from 2 to n, mark all number which is multiplier of 2
    public int countPrimes(int n) {
    	boolean[] prime = new boolean[n];
    	Arrays.fill(prime, true);
    	
    	for(int i=2; i*i<n; i++){
    		if(!prime[i]) continue;
    		for(int j=i; i*j<n; j++){
    			prime[i*j] = false;
    		}
    	}
    	int count = 0;
    	for(int i=2; i<n; i++){
    		if(prime[i]) count++;
    	}
    	return count;
    }
    
    
	public static void main(String[] args) {
		CountPrimes c = new CountPrimes();
		System.out.println(c.countPrimes(499979));
	}

}
