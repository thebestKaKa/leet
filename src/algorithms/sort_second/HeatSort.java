package algorithms.sort_second;

public class HeatSort extends sort {
    //堆排序
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = N/2; i > 0 ; i--) {
            sink(a, i, N);
        }
        while (N > 1){
            exch(a,1, N--);
            sink(a, 1, N);
        }
    }

    public static void swim(){

    }

    public static void sink(Comparable[] a, int k, int N){
        while (k <= N/2){
            int j = 2 * k;
            if (j < N && less(a, j, j + 1))j++;
            if (less(a, j, k))break;
            exch(a, k, j);
            k = j;
        }
    }

    public static boolean less(Comparable[] a, int i, int j){
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    public static void main(String[] args) {
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        String[] a = {"R", "B", "W", "W", "R", "W", "B", "R", "R", "W", "B", "R"};
        show(a);
        sort(a);
        show(a);
        //A E E L M O P R S T X
    }
}
