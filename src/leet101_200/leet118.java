package leet101_200;

import java.util.*;

public class leet118 {
    //杨辉三角
    public static List<List<Integer>> generate(int numRows) {
        int i,j;
        List<List<Integer>> ans = new LinkedList<>();
        for (i = 0;i < numRows; i++){
            List<Integer> t = new ArrayList<>();
            for (j = 0;j < i + 1; j++){
                if (j == 0)t.add(1);
                else if (j == i)t.add(1);
                else {
                    t.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(t);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = generate(6);
        System.out.print(a);
    }
}
