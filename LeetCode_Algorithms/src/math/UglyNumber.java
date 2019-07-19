package math;

public class UglyNumber {

	   public boolean isUgly(int num) {
		   if(num == 0) return false;
		   int[] primes = {2,3,5};
		   for(int prime : primes){
			   while(num%prime == 0){
				   num = num/prime;
			   }
		   }
		   return num==1 ? true : false;
	   }
	
	   public static void main(String[] args){
		   UglyNumber u = new UglyNumber();		   
		   System.out.println(u.isUgly(6));
		   System.out.println(u.isUgly(8));
		   System.out.println(u.isUgly(14));		   
	   }
}
