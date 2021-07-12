package problem275;

import java.util.HashMap;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/12 3:31 下午
 */
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            if (citations[0] == 0) return 0;
            else return 1;
        }
        int res = 0, l = 0, r = citations.length - 1;
        while (l <= r) {
            int mid = (r - l) >> 2 + l;
            int attr = (citations.length - mid);
            if (citations[mid] >= attr) {
                if (citations[Math.max(mid - 1, 0)] < attr) {
                    res = attr;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            } else if (citations[mid] < attr) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6};

        Solution solution = new Solution();
        System.out.println(solution.hIndex(arr));

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
    }
}