package contest231.problem5697;

class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();

        int i = 1;
        while (i < n && s.charAt(i) == '1') {
            i++;
        }
        while (i < n) {
            if (s.charAt(i) == '1') {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkOnesSegment("110111"));
    }
}