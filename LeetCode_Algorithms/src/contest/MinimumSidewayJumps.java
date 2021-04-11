package contest;

public class MinimumSidewayJumps {

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int count = 0;
        int curLane = 2;
        int i = 1;
        while(i < n - 1) {
            if (obstacles[i] == curLane) {
                int[] jump = findNextJump(curLane, i-1, obstacles);
                if(jump == null) return count + 1;
                i = jump[0];
                curLane = jump[1];
                count ++;
            }
            i++;

        }
        return count;
    }

    private int[] findNextJump(int lane, int index, int[] obstacles) {
        int a = 0,b = 0;
        int n = obstacles.length;
        int[] res = new int[2];
        if(lane == 1) {
            a = 2; b = 3;
        } else if (lane == 2) {
            a = 1; b = 3;
        } else if (lane == 3) {
            a = 1; b = 2;
        }

        int i = index;
        boolean foundA = false;
        boolean foundB = false;
        for(; i < n-1; i++) {
            if(obstacles[i] == a) {
                foundA = true;
            } else if (obstacles[i] == b) {
                foundB = true;
            }

            if(foundA && foundB) {
                return new int[] {i-1, obstacles[i]};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MinimumSidewayJumps j = new MinimumSidewayJumps();
        int[] o1 = {0,1,2,3,0};
        int[] o2 = {0,1,1,3,3,0};
        int[] o3 = {0,3,3,0,3,2,2,0,0,3,0};
        System.out.println(j.minSideJumps(o1));
        System.out.println(j.minSideJumps(o2));
        System.out.println(j.minSideJumps(o3));
    }
}
