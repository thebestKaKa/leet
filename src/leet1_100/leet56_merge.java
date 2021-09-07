package leet1_100;

import java.util.List;

public class leet56_merge {
    //合并区间
    private static int[][] aux;

    public static boolean less(int[] a, int[] b){
        if (a[0] < b[0] || (a[0] == b[0] && a[1] < b[1])) return true;
        return false;
    }

    public static void sort(int[][] a){
        //归并排序
        aux = a.clone();
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[][] a, int low, int high){
        if (low >= high)return;
        int mid = (low + high)/2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        mergeOfSort(a, aux, low, mid, high);
    }

    public static void mergeOfSort(int[][] a, int[][] aux, int low, int mid, int high){
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) a[k] = aux[j++];
            else if (j == high + 1) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else if (!less(aux[i], aux[j])) a[k] = aux[j++];
        }
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1)return intervals;
        sort(intervals);
        int i = 0, j = 1;
        int count = 0;
        int[][] ans = new int[intervals.length][2];

        while (true){
            if (intervals[i][0] == intervals[j][0]){//1
                while (intervals[i][0] == intervals[j][0]){
                    i++;
                    j++;
                    if (j > intervals.length - 1)break;
                }
            }else if (intervals[i][1] > intervals[j][0]){
                if (intervals[i][1] <= intervals[j][1]){//2
                    intervals[i][1] = intervals[j][1];
                }//3
                j++;
            }else if (intervals[i][1] == intervals[j][0]){//4
                intervals[i][1] = intervals[j][1];
                j++;
            }else if (intervals[i][1] < intervals[j][0]){//5
                ans[count] = intervals[i];
                count++;
                i = j;
                j++;
            }
            if (j > intervals.length - 1){
                ans[count] = intervals[i];
                count++;
                break;
            }
        }
        int[][] res = new int[count][2];
        for (int k = 0; k < res.length; k++) {
            res[k] = ans[k];
        }
        return res;
    }

    public static void show(int[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(" " + a[i][0] + " " + a[i][1]);
        }
    }

    public static void main(String[] args) {
        int[][] tst = {
                {-2, -1},
                {-1, 0},
                {0, 2},
                {0, 4},
                {0, 5},
                {1, 3},
                {6, 8},
                {7, 9},
                {10, 11}
        };
        show(merge(tst));
    }
}
