package contest;

import java.util.*;

public class FairDistributionofCookies {

    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        if(k == cookies.length) return cookies[k - 1];

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i ++)
            list.add(0);
        backTrack(cookies, k, list, 0) ;
        return res;
    }

    private void backTrack(int[] cookies, int k, List<Integer> list, int index) {
        if(index >= cookies.length) {
            Collections.sort(list);
            res = Math.min(list.get(list.size() - 1), res);
            return;
        }

        for(int i = 0; i < k; i ++) {
            List<Integer> copy = new ArrayList<>(list);
            copy.set(i, copy.get(i) + cookies[index]);
            backTrack(cookies, k, copy, index + 1);
        }
    }

    public static void main(String[] args) {
        FairDistributionofCookies f = new FairDistributionofCookies();
        System.out.println(f.distributeCookies(new int[] {8,15,10,20,8}, 2));
        System.out.println(f.distributeCookies(new int[] {6,1,3,2,2,4,1,2}, 3));
    }
}
