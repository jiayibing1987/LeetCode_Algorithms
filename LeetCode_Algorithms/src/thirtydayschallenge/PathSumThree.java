package thirtydayschallenge;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumThree {

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 ,1);
        dfs(root, 0, sum, map);
        return count;
    }

    private void dfs(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if(root == null) return;
        sum += root.val;
        if(map.containsKey(sum - target))
            count = count + map.get(sum - target);

        if(map.containsKey(sum)) {
            map.put(sum, map.get(sum)+1);
        }else {
            map.put(sum, 1);
        }

        dfs(root.left, sum, target, map);
        dfs(root.right, sum, target, map);
        if(map.get(sum) == 1)
            map.remove(sum);
        else
            map.put(sum, map.get(sum)-1);
    }
}
