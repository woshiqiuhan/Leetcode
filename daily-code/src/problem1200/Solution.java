package problem1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/09 8:44 下午
 */
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return res;
        }

        Arrays.sort(arr);
        int minAbs = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minAbs = Math.min(minAbs, arr[i] - arr[i - 1]);
        }

        for (int i = 1; i < arr.length; i++) {
            if (minAbs == arr[i] - arr[i - 1]) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }
}