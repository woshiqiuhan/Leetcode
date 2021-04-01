package contest231.problem5698;

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long attr = goal - sum;

        if (attr < 0) {
            attr = -attr;
        }

        long n =  attr / limit;
        return attr % limit == 0 ? (int) n : (int) n + 1;
    }
}