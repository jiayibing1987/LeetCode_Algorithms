package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
    	map.put(5, 0);
    	map.put(10, 0);
    	
    	for(int i=0; i<bills.length; i++){
    		if(bills[i] == 5){
    			map.put(5, map.get(5)+1);
    		}else if(bills[i] == 10){
    			if(map.get(5) > 0){
    			  map.put(5, map.get(5)-1);
    			  map.put(10, map.get(10)+1);
    			}
    			else
    				return false;
    		}else{
    			if(map.get(5)>0 && map.get(10)>0){
    				map.put(5, map.get(5)-1);
    				map.put(10, map.get(10)-1);
    			}else if(map.get(5) >=3){
    				map.put(5, map.get(5)-3);
    			}
    			else{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    
	public static void main(String[] args) {
		LemonadeChange l = new LemonadeChange();
		int[] a1 = new int[]{5,5,5,10,20};
		int[] a2 = new int[]{5,5,10};
		int[] a3 = new int[]{10,10};
		int[] a4 = new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
		
		System.out.println(l.lemonadeChange(a1));
		System.out.println(l.lemonadeChange(a2));
		System.out.println(l.lemonadeChange(a3));
		System.out.println(l.lemonadeChange(a4));
	}

}
