package greedy;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        long covered = 0;
        int i = 0;
        int count = 0;

        while (covered < n) {
            if (i >= nums.length || covered + 1 < nums[i]) {
                long miss = covered + 1;
                count++;
                covered = covered + miss;
            } else {
                covered += nums[i++];
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
