package leet101_200;

public class leet_200_optiz {
    //岛屿数量 并查集 路径压缩 按秩合并
    public static class UF{
        private int[] id;
        private int[] sz; // 标记位
        private int count = 0;

        public UF(char[][] grid){
            int m = grid.length;
            int n = grid[0].length;
            id = new int[m * n];
            sz = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    id[i * n + j] = i * n + j;
                    sz[i * n + j] = 1;
                    if (grid[i][j] == '1') count++;
                }
            }
        }

        public int find(int p, int q, int n){
            int pId = p * n + q;
            int root = pId;
            while (id[root] != root) root = id[root];
            //路径压缩
            while (id[pId] != pId) {
                int temp = id[pId];
                id[pId] = root;
                pId = temp;
            }
            return root;
        }

        public void union(int p, int q, int a, int b, int n){
            int pRoot = find(p, q, n);
            int aRoot = find(a, b, n);
            if (pRoot == aRoot)return;
            //按秩合并
            //小树连到大树上 只修改了根节点 所以可以路径压缩
            if (sz[pRoot] < sz[aRoot]){
                id[pRoot] = aRoot;
                sz[aRoot] += sz[pRoot];
            }else {
                id[aRoot] = pRoot;
                sz[pRoot] += sz[aRoot];
            }
            count--;
        }
    }
    public static int numIslands(char[][] grid) {
        if (grid.length == 0)return 0;
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 && j == n - 1){
                    break;
                }else if (j == n - 1){
                    if (grid[i][j] == grid[i + 1][j] && grid[i][j] == '1')
                        uf.union(i, j, i + 1, j, n);
                }else if (i == m - 1){
                    if (grid[i][j] == grid[i][j + 1] && grid[i][j] == '1')
                        uf.union(i, j, i, j + 1, n);
                }else {
                    if (grid[i][j] == grid[i + 1][j] && grid[i][j] == '1')
                        uf.union(i, j, i + 1, j, n);
                    if (grid[i][j] == grid[i][j + 1] && grid[i][j] == '1')
                        uf.union(i, j, i, j + 1, n);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
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
        System.out.println(numIslands(grid2));
    }

}
