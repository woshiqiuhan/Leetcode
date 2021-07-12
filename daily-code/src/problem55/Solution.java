package problem55;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/09 8:27 下午
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        int maxRight = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i <= maxRight) {
                maxRight = Math.max(maxRight, i + nums[i]);
                if (maxRight >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}