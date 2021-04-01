package problem33;

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (target == nums[0]) {
            return 0;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[0]) {
                // 左边有序
                if (nums[0] <= target && target < nums[mid]) {
                    // 答案在左侧
                    r = mid - 1;
                } else {
                    // 答案在右侧
                    l = mid + 1;
                }
            } else {
                // 如果右侧有序
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    // 答案在右侧
                    l = mid + 1;
                } else {
                    // 答案在右侧
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}