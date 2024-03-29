package algorithms.sort_second;

public class SelectionSort extends sort{

    public static void sort(Comparable[] a){
        //选择排序
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        show(a);
        sort(a);
        show(a);
        //A E E L M O P R S T X
    }
}
