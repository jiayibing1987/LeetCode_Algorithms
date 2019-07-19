package twopointer;
/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * @author Ryan
 *
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        char[] num = Integer.toString(x).toCharArray();
    	int i=0, j = num.length-1;
    	//reverse string then compare with orginal
    	while(i<j){
    		char temp = num[j];
    		num[j] = num[i];
    		num[i] = temp;
    		i++;
    		j--;
    	}
    	return new String(num).equals(Integer.toString(x));
    }
    
	
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(121));
		System.out.println(p.isPalindrome(-121));
	}

}
