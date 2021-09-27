package algorithms.sort_second;

public class ShellSort extends sort {
    public static void sort(Comparable[] a){
        //希尔排序 对每个h数组独立进行插入排序
        int h = 1;
        while (h < a.length/3) h = h * 3 + 1;
        while (h >= 1){
            for (int k = 0; k < h; k++) {
                for (int i = k + h; i < a.length; i += h) {
                    for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                        exch(a, j, j - h);
                    }
                }
            }
            h /= 3;
        }
    }

    public static void sort_opz(Comparable[] a){
        //希尔排序 优化
        int h = 1;
        while (h < a.length/3) h = h * 3 + 1;
        while (h >= 1){
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exch(a, j, j - h);
                }
            }
            h /= 3;
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
