package greedy;

import java.util.Arrays;

public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        for(int[] r : res)
            Arrays.fill(r, -1);

        Arrays.sort(people, (a,b) -> a[0]-b[0] == 0 ? a[1]-b[1] : a[0]-b[0]);

        for(int i=0; i<people.length; i++) {
            int count = 0;
            for(int j=0; j<res.length; j++) {
                if(res[j][0] == -1 && count == people[i][1]) {
                    res[j][0] = people[i][0];
                    res[j][1] = people[i][1];
                    break;
                }

                if(res[j][0] >= people[i][0] || res[j][0] == -1)
                    count ++;
            }
        }
        return res;
    }

}
