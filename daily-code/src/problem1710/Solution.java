package problem1710;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/09 7:57 下午
 */
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }


        int mainPos = -1, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                mainPos = num;
                cnt++;
            } else {
                if (mainPos == num) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }

        cnt = 0;
        for (int num : nums) {
            if (num == mainPos) {
                cnt++;
            }
        }

        return cnt * 2 > nums.length ? mainPos : -1;
    }
}