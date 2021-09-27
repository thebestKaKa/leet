package algorithms.sort_second;

import algs4.StdRandom;

public class QuickSort extends sort {
    private static int partition(Comparable[] a, int low, int high){
        //快速排序，切分
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true){
            while (less(a[++i], v));
            while (less(v, a[--j]));
            if (i >= j)break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    public static void sort(Comparable[] a){
        //快速排序
        StdRandom.shuffle(a);
        //哨兵
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (less(a[max], a[i])) max = i;
        }
        exch(a, max, a.length - 1);
        //
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high){
        //快速排序
        if (low >= high) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    public static void sort_wrong(Comparable[] a, int low, int high){
        //快速排序 三向切分
        if (low >= high)return;
        int lt = low, gt = high;
        int i = low + 1;
        Comparable v = a[low];
        while (i <= gt){
            System.out.println(i);
            show(a);
            int cmp = v.compareTo(a[i]);
            if (cmp > 0) { lt++; i++; }
            else if (cmp < 0) exch(a, i, gt--);
            else i++;
            //如果前几个值一样的话  lt可能不能准确定位到最后一个小于v的值并进行交换
        }
        exch(a, low, lt);
        sort_wrong(a, low, lt - 1);
        sort_wrong(a, gt + 1, high);
    }

    public static void sort_(Comparable[] a, int low, int high){
        //快速排序 三向切分
        if (low >= high)return;
        int lt = low, gt = high;
        int i = low + 1;
        Comparable v = a[low];
        while (i <= gt){
            int cmp = v.compareTo(a[i]);
            if (cmp > 0) exch(a, i++, lt++);
            else if (cmp < 0) exch(a, i, gt--);
            else i++;
        }
        sort_(a, low, lt - 1);
        sort_(a, gt + 1, high);
    }

    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        String[] b = {"R", "B", "W", "W", "R", "W", "B", "R", "R", "W", "B", "R"};
        show(a);
        sort(a);
        show(a);
        //A E E L M O P R S T X
    }
}
