package problem5;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.equals("bb")) {
            return s;
        }
        int n = s.length();
        String res = s.charAt(0) + "";
        for (int i = 0; i < n; i++) {
            // 找奇数串
            int l = i - 1, r = i + 1;
            if (l >= 0 && r < n) {
                res = getString(s, n, res, l, r);
            }
            // 找偶数串
            r = i + 1;
            if (r < n - 1 && s.charAt(r) == s.charAt(i)) {
                l = i;
                res = getString(s, n, res, l, r);
            }

        }
        return res;
    }

    private String getString(String s, int n, String res, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if (res.length() < r - l + 1) {
            res = s.substring(l, r + 1);
        }
        return res;
    }
}