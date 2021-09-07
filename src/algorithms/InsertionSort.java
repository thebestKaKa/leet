package algorithms;

public class InsertionSort extends sort {
    public static void sort(Comparable[] a){
        //插入排序
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]) ; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void sort_opz(Comparable[] a){
        //插入排序 小改进
        for (int i = 1; i < a.length; i++) {
            int j = i;
            Comparable t = a[j];
            //while (j > 0 && less(a[j], a[j - 1])){
            while (j > 0 && less(t, a[j - 1])){
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        show(a);
        sort_opz(a);
        show(a);
        //A E E L M O P R S T X
    }
}
