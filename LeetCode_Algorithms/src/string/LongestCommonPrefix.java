package string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
    	String result = "";
    	if(strs.length == 0) return result;
    	for(int i=0; i<strs[0].length(); i++){
    		char lastCh = 0;
    		for(int j=0; j<strs.length; j++){
    			if(i>=strs[j].length()) return result;
    			if(j==0) lastCh = strs[j].charAt(i);
    			char ch = strs[j].charAt(i);
    			if(ch != lastCh) return result;
    		}
    		result += Character.toString(lastCh); 
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		LongestCommonPrefix l = new LongestCommonPrefix();
		String[] a = {"flower","flow","flight"};
		String[] b = {"dog","racecar","car"};
		System.out.println(l.longestCommonPrefix(a));
		System.out.println(l.longestCommonPrefix(b));
	}

}
