package leet1001_1200;

import java.util.*;

public class leet1002 {
    public List<String> commonChars(String[] A) {
        //此题不适合使用hashmap 因为无法遍历输出？？？可以 使用map.keyset
        List<String> ans = new LinkedList<>();
        HashMap<String, Integer> m = new HashMap<>();
        HashMap<String, Integer> n;

        char[] ch = A[0].toCharArray();
        for (char c : ch) {
            String s = String.valueOf(c);
            if (m.containsKey(s)) {
                int count = m.get(s);
                m.put(s, count + 1);
            } else m.put(s, 1);
        }
        for (int i = 1;i < A.length;i++){
            char[] temp = A[i].toCharArray();
            n = m;
            for (char c : temp) {
                String s = String.valueOf(c);
                if (n.containsKey(s)) {
                    int count = n.get(s);
                    n.put(s, count - 1);
                }
            }
        }
        return ans;
    }

    public List<String> commonChars_2(String[] A) {
        List<String> ans = new LinkedList<>();
        int[] minfreq = new int[26];
        Arrays.fill(minfreq,Integer.MAX_VALUE);
        for (String s : A) {
            int[] freq = new int[26];
            char[] ch = s.toCharArray();
            for (char c : ch) {
                freq[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                minfreq[j] = Math.min(minfreq[j], freq[j]);
            }
        }
        for (int i = 0;i < 26;i++){
            while (minfreq[i] != 0){
                String temp = String.valueOf((char)('a' + i));
                ans.add(temp);
                minfreq[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((char)('a' + 2));
    }
}
