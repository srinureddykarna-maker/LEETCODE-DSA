import java.util.*;

class Solution {
    void generate(int[] candidates, int target, int index,
                  List<Integer> current, int sum,
                  List<List<Integer>> ans) {

        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length || sum > target) {
            return;
        }
        current.add(candidates[index]);
        generate(candidates, target, index, current,
                 sum + candidates[index], ans);

        current.remove(current.size() - 1);

        generate(candidates, target, index + 1, current, sum, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(candidates, target, 0, new ArrayList<>(), 0, ans);
        return ans;
    }
}