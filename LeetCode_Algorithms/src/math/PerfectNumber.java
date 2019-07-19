package math;

import java.util.ArrayList;
import java.util.List;

/*#507
 * We define the Perfect Number is a positive integer that is equal to the 
 * sum of all its positive divisors except itself.*/
public class PerfectNumber {
    
	public boolean checkPerfectNumber(int num) {
		if(num == 0 || num == 1)
			return false;
		List<Integer> l = new ArrayList<Integer>();
		for(int i=1; i<num; i++){
			if(num % i == 0)
				l.add(i);
		}
		
		int sum = 0;
		for(Integer i : l){
			sum = sum + i;
		}
		return num == sum ? true : false;
    }
	
	public static void main(String[] args) {
		PerfectNumber p = new PerfectNumber();
		System.out.println(p.checkPerfectNumber(28));
	}

}
