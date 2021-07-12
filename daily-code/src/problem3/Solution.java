package problem3;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/12 7:37 下午
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] lastPresentPos = new int[1000];
        // 5 8 6
        Arrays.fill(lastPresentPos, -1);
        int curLen = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastPresentPos[s.charAt(i)] == -1) {
                curLen++;
            } else {
                // 更新最长非重复字串
                maxLen = Math.max(maxLen, curLen);
                for (int j = i - curLen; j < lastPresentPos[s.charAt(i)]; j++) {
                    lastPresentPos[s.charAt(j)] = -1;
                }
                curLen = i - lastPresentPos[s.charAt(i)];
            }
            lastPresentPos[s.charAt(i)] = i;
        }

        return Math.max(maxLen, curLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
}