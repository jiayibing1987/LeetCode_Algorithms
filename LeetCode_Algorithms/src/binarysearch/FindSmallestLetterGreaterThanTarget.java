package binarysearch;

/**
 * 744. Find Smallest Letter Greater Than Target
 * @author Ryan
 *
 */
public class FindSmallestLetterGreaterThanTarget {
// time:o(n)
//    public char nextGreatestLetter(char[] letters, char target) {
//    	for(char c: letters){
//    		if(c > target)
//    			return c;
//    	}
//    	return letters[0];
//    }
    
	//binary search O(logN)
    public char nextGreatestLetter(char[] letters, char target) {
    	int low = 0;
    	int high =  letters.length-1;
    	                        
    	while(low<high){
    		int mid = (low+high)/2;
    		if(letters[mid] <= target)
    			low = mid+1;
    		else
    			high = mid-1;
    			
    	}
    	//low == high at this stage, 
    	if(target < letters[low]){
    		return letters[low];
    	}else{
    		//if low is not the last index of array return next index of low
    		if(low<letters.length-1)
    			return letters[low+1]; 
    		//if low is last index, means target is higher than all letters in array, return first element of array
    		else
    			return letters[0];
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
