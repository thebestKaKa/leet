package algorithms;

import algs4.StdOut;

public class array_copy {

    public static int[][] matrix_mutiple(int[][] a, int[][] b){
        int[][] ans = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    public int test(int a, int b){
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(a);
        int[] b = a;
        System.out.println(b);
        int[][] c = {
                {1,2,4,5},
                {2,3,4,6},
                {3,4,5,6},
                {7,8,9,4}
        };
        int[][] d = {
                {1,2,4,5},
                {2,3,4,6},
                {3,4,5,6},
                {7,8,9,4}
        };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(matrix_mutiple(c, d)[i][j]);
            }
        }

        // System.out.printf("%14.4f", 2.3123213421312);
        System.out.println("---------");
        System.out.println(1 + 2 + "3");

    }
}
