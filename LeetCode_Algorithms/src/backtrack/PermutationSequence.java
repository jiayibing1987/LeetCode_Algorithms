package backtrack;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        if(n<1) return "";
        count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
        	sb.append(i);
        }
       return backTrack(sb.toString(), "", k);
    }
    
    int count;
    private String backTrack(String remain, String prefix, int k){
    	if(remain.length() == 0){
    		if(count == k){
    			return prefix;
    		}
    		else{
    			count++;
    			return null;
    		}
    	}else{
    		for(int i=0; i<remain.length(); i++){
    			String s = backTrack(remain.substring(0,i)+remain.substring(i+1),
    					prefix+String.valueOf(remain.charAt(i)), k);
    			if(s != null) return s;
    		}
    	}	
    	return null;
    }
    
	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(3, 3));
		System.out.println(p.getPermutation(4, 9));

	}

}
