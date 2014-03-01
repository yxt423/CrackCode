package leetCode;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], 0);
        }
        
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int cur = num[i];
            if(map.containsKey(cur)) {
                while (map.containsKey(cur) && (!map2.containsKey(cur))) {
                    map.remove(cur);
                    cur++;
                }
                if (map2.containsKey(cur)) {
                    max = Math.max(max, cur - num[i] + map2.get(cur));
                    map2.put(num[i], cur - num[i] + map2.get(cur));
                    continue;
                }
                max = Math.max(max, cur - num[i]);
                map2.put(num[i], cur - num[i]);
            }
        }
        return max;
    }
}