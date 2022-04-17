package contest;

import java.util.LinkedList;
import java.util.List;

public class CalculateDigitSumofaString {

    public String digitSum(String s, int k) {
        LinkedList<Character> list = new LinkedList<>();

        for(char c : s.toCharArray()){
            list.add(c);
        }

        while(list.size() > k) {
            LinkedList nextList = new LinkedList();
            int sum = 0;
            int count = 0;
            for(int i = 0; i < list.size(); i ++) {
                char c = list.get(i);
                int val = Character.getNumericValue(c);
                sum += val;
                count ++;
                if(count == k || i == list.size() - 1) {
                    String sum_String = String.valueOf(sum);
                    for(char newChar : sum_String.toCharArray()) {
                        nextList.add(newChar);
                    }
                    sum = 0;
                    count = 0;
                }
            }
            list = new LinkedList<>(nextList);
        }

        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()) {
            sb.append(list.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CalculateDigitSumofaString c = new CalculateDigitSumofaString();
        System.out.println(c.digitSum("11111222223", 3));

        System.out.println(c.digitSum("01234567890", 2));
    }
}
