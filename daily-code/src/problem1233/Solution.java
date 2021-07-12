package problem1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/09 8:50 下午
 */
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        if (folder == null || folder.length < 2) {
            return new ArrayList<>();
        }

        Arrays.sort(folder, (o1, o2) -> Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2)));

        for (int i = 0; i < folder.length; i++) {
            if (folder[i] == null) {
                continue;
            }
            for (int j = i + 1; j < folder.length; j++) {
                if (folder[j].startsWith(folder[j])) {
                    folder[j] = null;
                }
            }
        }

        return Arrays.asList(folder);
    }


}