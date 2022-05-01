package contest;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardstoPickUp {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int count = 0;
        int min = cards.length + 1;
        for(int r = 0; r < cards.length; r ++) {
            map.put(cards[r], map.getOrDefault(cards[r], 0) + 1);
            if(map.get(cards[r]) == 2)
                count ++;

            while(count > 1 || (count == 1 && map.containsKey(cards[l]) && map.get(cards[l]) != 2)) {
                map.put(cards[l], map.get(cards[l]) - 1);
                if (map.get(cards[l]) == 1)
                    count--;
                l++;
            }
            if (count > 0) {
                min = Math.min(r - l + 1, min);
            }
        }
        return min > cards.length ? -1 : min;
    }

    public static void main(String[] args) {
        MinimumConsecutiveCardstoPickUp c=  new MinimumConsecutiveCardstoPickUp();
        int[] c1 = new int[] {3,4,2,3,4,7};
       // System.out.println(c.minimumCardPickup(c1));

        int[] c2 = new int[] {95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6};
        System.out.println(c.minimumCardPickup(c2));
    }
}
