package string;

/**
 * 58. Length of Last Word
 * @author Ryan
 *
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        int count = 0;
        if(s == null || s.isEmpty()) return count;
    	for(int i=s.length()-1; i>=0; i--){
        	if(String.valueOf(s.charAt(i)).equals(" ") ){
        		if(count != 0)
        			return count;
        		else
        			continue;
        	}
        	count++;	
        }
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
