package problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = n - 1;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int attr = -nums[i] - nums[j];
                while (k > j && nums[k] > attr) {
                    k--;
                }
                if (k == j) {
                    break;
                }
                if (nums[k] == attr) {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return lists;
    }
}