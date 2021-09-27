package algorithms.sort_second;

public class sort {
    public static void sort(Comparable[] a){

    }

    public static boolean less(Comparable v, Comparable w){
        //v < w
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a){
        //在单行打印数组
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length - 1; i++) {
            if (!less(a[i], a[i + 1])) return false;
        }
        return true;
    }
}
