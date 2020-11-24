package leet201_300;

import java.util.Arrays;
import java.util.HashMap;

public class leet242 {
    public static boolean isAnagram(String s, String t) {
        //这里可以使用普通数组代替 HashMap 用ascii来定位
        if (s.length() != t.length())return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        System.out.println(map);
        for (int i = 0; i < t.length(); i++){
            if (!map.containsKey(t.charAt(i))){
                return false;
            }else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        System.out.println(map);
        for (char c : map.keySet()){
            if (map.get(c) != 0)return false;
        }
        return true;
    }

    public static boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length())return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram_2("abc", "bca"));
    }
}
