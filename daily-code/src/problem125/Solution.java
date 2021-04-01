package problem125;

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int n = s.length();
        if (n == 0) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l >= r && !((s.charAt(l) >= '0' && s.charAt(l) <= '9') ||
                    (s.charAt(l) >= 'a' && s.charAt(l) <= 'z'))) l++;
            while (l >= r && !((s.charAt(r) >= '0' && s.charAt(r) <= '9') ||
                    (s.charAt(r) >= 'a' && s.charAt(r) <= 'z'))) r--;
            System.out.println(l + " " + r);
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}