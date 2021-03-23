package gyq.java.algorithm.leetcode.p438_find_all_anagrams_in_a_string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @see 滑动窗口
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return new LinkedList<>();
        }
        // int[] needs = new int[26];
        // int[] window = new int[26];
        Map<Character, Integer> needsMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            // map的方式
            char key = p.charAt(i);
            needsMap.put(key, needsMap.getOrDefault(key, 0) + 1);
            // 数组的方式
            // needs[key - 'a']++;
        }
        Map<Character, Integer> windowMap = new HashMap<>();


        int right = 0;
        int left = 0;
        int isValidCount = 0;
        List<Integer> result = new LinkedList<>();
        while (right <= s.length() - 1) {
            // 即将进入窗口的字符
            char rightChar = s.charAt(right);
            // 窗口右界右移
            right++;
            Integer valueNeed = needsMap.get(rightChar);
            if (valueNeed != null) {
                // 需要这个字符
                int valueWindow = windowMap.getOrDefault(rightChar, 0) + 1;
                windowMap.put(rightChar, valueWindow);
                if (valueWindow == valueNeed) {
                    // 有一个字母满足数量要求了,计数++
                    isValidCount++;
                }
            }
            // 判断左侧窗口是否需要收紧
            while (right - left >= p.length()) {
                if (isValidCount == needsMap.size()) {
                    // 已经有足够的字母满足要求
                    result.add(left);
                }
                // 即将移出窗口的字符
                char leftChar = s.charAt(left);
                // 窗口左界右移
                left++;
                Integer valueNeedLeft = needsMap.get(leftChar);
                if (valueNeedLeft != null) {
                    // 需要这个字符
                    int valueWindow = windowMap.get(leftChar);
                    if (valueWindow == valueNeedLeft) {
                        // 有一个字母满足数量要求了,计数++
                        isValidCount--;
                    }
                    windowMap.put(leftChar, valueWindow - 1);
                }
            }
        }
        return result;
    }
}