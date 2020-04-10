package thirtydayschallenge;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        do{
             int temp = getResult(n);
             if(map.containsKey(n))
                 return false;
             else
                 map.put(n, temp);
             n = temp;
        }while(n != 1);
        return true;
    }

    private int getResult(int n){
        String s = Integer.toString(n);
        int res = 0;
        for(char c : s.toCharArray()){
            int i = Character.getNumericValue(c);
            res += i*i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
