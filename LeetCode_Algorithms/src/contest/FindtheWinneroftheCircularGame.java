package contest;

import java.util.LinkedList;
import java.util.List;

public class FindtheWinneroftheCircularGame {

    public int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++) {
            list.add(i);
        }

        int size = n;
        int index = 0;
        while(size > 1) {
            int toBeRemoved = (index + k - 1) % size;
            index = toBeRemoved;
            list.remove(toBeRemoved);
            size --;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        FindtheWinneroftheCircularGame f = new FindtheWinneroftheCircularGame();
        System.out.println(f.findTheWinner(5, 2));
        //System.out.println(res2);

    }
}
