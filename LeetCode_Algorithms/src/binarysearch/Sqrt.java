package binarysearch;

public class Sqrt {

    public int mySqrt(int x) {
    	if(x==0) return 0;
        int low = 1;
        int high = x;
        while(low <= high){
        	int mid = (low+high)/2;
        	if(mid*mid == x) return mid;
        	if(mid  > x/mid) //can't use mid*mid because it may exceed maximum integer value
        		high = mid-1;
        	else
        		low = mid+1;
        }
        
        return low < x/low? low:low-1;
    }
    
	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(1000000));
	}

}
