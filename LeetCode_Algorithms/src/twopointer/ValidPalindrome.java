package twopointer;


/**
 * #125
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * @author Ryan
 *
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
    	s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    	int i = 0;
    	int j = s.length()-1;
    	boolean isPalindrome = true;
    	
    	while(i<j){
    		if(s.charAt(i) != s.charAt(j)){
    			isPalindrome = false;
    			break;
    		}else{
    			i++;
    			j--;
    		}
    	}
    	return isPalindrome;
    }
	
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		String a = "A man, a plan, a canal: Panama";
		System.out.println(v.isPalindrome(a));
		
		String b = "race a car";
		System.out.println(v.isPalindrome(b));
		
		System.out.println(v.isPalindrome(""));
	}

}
