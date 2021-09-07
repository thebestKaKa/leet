package algorithms;

public class MergeSort extends sort{

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int low, int mid, int high){
        //归并a[low..mid]和a[mid+1..high]
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if(j > high) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
        System.out.println("a:");
        show(a);
    }

    public static void sort(Comparable[] a){
        //归并排序 自顶向下
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high){
        //归并排序 自顶向下
        if (low >= high) return;
        int mid = low + (high - low)/2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        //if (less(a[mid], a[mid + 1])) return;
        merge(a, low, mid, high);
    }

    public static void sort_(Comparable[] a){
        //归并排序 自底向上
        aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz = sz * 2) {
            for (int i = 0; i < a.length - sz; i += sz + sz) {
                merge(a, i, i + sz - 1, Math.min(i + sz + sz - 1, a.length - 1));
            }
        }
    }


    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        show(a);
        sort_(a);
        show(a);
        //A E E L M O P R S T X
    }
}
