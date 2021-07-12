package problem1711;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/07 8:29 下午
 */
class Solution {
    private static final int MOD = 1000000000 + 7;

    public int countPairs(int[] deliciousness) {
        if (deliciousness == null || deliciousness.length < 2) {
            return 0;
        }

        long cnt = 0;
        int[] pow2Arr = new int[25];
        pow2Arr[0] = 1;
        for (int i = 1; i <= 24; i++) {
            pow2Arr[i] = 2 * pow2Arr[i - 1];
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int item : deliciousness) {
            mp.put(item, mp.getOrDefault(item, 0) + 1);
        }

        Set<Integer> keySet = mp.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            for (int i = 0; i <= 24; i++) {
                int attr = pow2Arr[i] - key;
                if (mp.containsKey(attr)) {
                    int attrCnt = mp.get(attr);
                    int keyCnt = mp.get(key);
                    if (key != attr) {
                        cnt = (cnt + ((long) keyCnt * attrCnt)) % MOD;
                    } else {
                        if (mp.get(key) >= 2) {
                            cnt = (cnt + (((long) keyCnt * (attrCnt - 1)) / 2)) % MOD;
                        }
                    }
                }
            }
            iterator.remove();
        }
        return (int) (cnt % MOD);
    }
}