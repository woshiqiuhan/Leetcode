package problem81;

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (target == nums[0] || target == nums[nums.length - 1]) {
            return true;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[l]) {
                // 左边有序
                if (nums[0] <= target && target < nums[mid]) {
                    // 答案在左侧
                    r = mid - 1;
                } else {
                    // 答案在右侧
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[l]) {
                // 如果右侧有序
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    // 答案在右侧
                    l = mid + 1;
                } else {
                    // 答案在右侧
                    r = mid - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }
}