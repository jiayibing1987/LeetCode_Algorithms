package greedy;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        long coverd = 0;
        int i = 0;
        int count = 0;

        while (coverd < n) {
            if (i >= nums.length || coverd + 1 < nums[i]) {
                long miss = coverd + 1;
                count++;
                coverd = coverd + miss;
            } else {
                coverd += nums[i++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PatchingArray p = new PatchingArray();
        int[] a1 = new int[]{1, 5, 10};
        System.out.println(p.minPatches(a1, 20));
    }
}
