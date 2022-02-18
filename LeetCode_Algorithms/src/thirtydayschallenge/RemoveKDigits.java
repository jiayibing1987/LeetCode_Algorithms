package thirtydayschallenge;

import java.util.ArrayDeque;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < num.length(); i ++) {
            int digit = Character.getNumericValue(num.charAt(i));
            //System.out.println(digit);
            while(!dq.isEmpty() && digit < dq.peekLast() && k > 0) {
                int removed = dq.pollLast();
                //System.out.println("remove " + removed);
                k--;
                //System.out.println("k " + k);
            }
            dq.addLast(digit);
        }

        //remove leading zero
        while(!dq.isEmpty() && dq.peekFirst() == 0)
            dq.pollFirst();

        while(!dq.isEmpty() && k > 0) {
            int removed = dq.pollLast();
            //System.out.println("post remove " + removed);
            k--;
        }

        if(dq.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}
