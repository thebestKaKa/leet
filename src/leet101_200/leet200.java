package leet101_200;

import java.util.HashSet;
import java.util.Set;

public class leet200 {
    //岛屿数量 并查集
    public static class UF{
        private int[][][] id;
        private int count = 0;

        public UF(char[][] grid){
            int m = grid.length;
            int n = grid[0].length;
            id = new int[m][n][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    id[i][j] = new int[]{i, j};
                    if (grid[i][j] == '1') count++;
                }
            }
        }

        public int[] find(int p, int q){
            while (id[p][q][0] != p || id[p][q][1] != q) {
                p = id[p][q][0];
                q = id[p][q][1];
            }
            //路径压缩
            return new int[]{p, q};
        }

        public void union(int p, int q, int m, int n){
            int[] lRoot = find(p, q);
            int[] rRoot = find(m, n);
            if (lRoot == rRoot)return;
            //合并root
            id[rRoot[0]][rRoot[1]] = lRoot;
            count--;
        }
    }
    public static int numIslands(char[][] grid) {
        if (grid.length == 0)return 0;
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(grid);
        //从左往右
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == grid[i][j + 1] && grid[i][j] == '1'){
                    uf.union(i, j, i, j + 1);
                }
            }
        }
        //从上往下
        int[][] history = new int[n][2];
        int count = 0;
        for (int i = 1; i < m; i++) {
            //合并过的根
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == grid[i - 1][j] && grid[i][j] == '1'){
                    //主要代码
                    boolean flag = false;
                    for (int[] ints : history) {
                        if (ints[0] == uf.find(i, j)[0] && ints[1] == uf.find(i, j)[1]) {
                            flag = true;
                        }
                    }
                    if (flag) continue;
                    history[count] = uf.find(i, j);
                    count++;
                    uf.union(i - 1, j, i, j);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        char[][] grid3 = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        System.out.println(numIslands(grid3));
    }
}
