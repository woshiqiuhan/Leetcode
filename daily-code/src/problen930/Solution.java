package problen930;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/08 9:14 上午
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cnt = 0;
        // 前缀和
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
            System.out.println(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] - nums[i] == goal) {
                    cnt++;
                }
            }
        }


        return cnt;
    }
}