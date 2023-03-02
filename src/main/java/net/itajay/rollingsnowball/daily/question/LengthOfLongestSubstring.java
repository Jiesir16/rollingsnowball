package net.itajay.rollingsnowball.daily.question;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023-03-02 无重复字符的最长子串
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj">无重复字符的最长子串</a>
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 思路
     * 遍历字符串，设置两个下标位置：start end
     * 定一个map<Key,Value> key:字符串中的字符  value:字符在该字符串的下标位置
     * start和end从0开始，start不动，end动，当遇到重复字符串，更新start为当前字符的下标，end继续，直到end为字符串最大长度
     *
     * @param s 字符串入参
     * @return 最长子串的长度
     */
    public static int lengthOfLongestSubstring(String s) {
        // 定义key:字符 val:字符在串中的下标
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // 定义最大长度,默认是0
        int max = 0;
        // 定义不重复字符串开始的下标
        int start = 0;
        // 遍历字符串的字符
        for (int end = 0; end < s.length(); end++) {
            Character character = s.charAt(end);
            if (charIndexMap.containsKey(character)) {
                // map中有该字符串，更新start，重复了，就更新start为后面字符的下标
                start = Math.max(charIndexMap.get(character) + 1, start);
            }
            // end - start + 1 避免出现两个下标指在同一个字符上，出现结果0的情况
            max = Math.max(end - start + 1, max);
            charIndexMap.put(character, end);
        }

        return max;
    }
}
