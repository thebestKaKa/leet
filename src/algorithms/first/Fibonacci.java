package algorithms.first;

public class Fibonacci {
    public static long[] F(int N){
        long[] Fibonacci = new long[N + 1];
        Fibonacci[0] = 0;
        if(N == 0){
            return Fibonacci;
        }
        Fibonacci[1] = 1;
        if(N == 1){
            return Fibonacci;
        }
        for (int i = 2; i <= N; i++) {
            Fibonacci[i] = Fibonacci[i-1] + Fibonacci[i-2];
        }
        return Fibonacci;
    }

    public static int array(int[] a){
        a[0] = 3;
        return 1;
    }

    public static void main(String[] args) {
        long[] F = F(99);
//        for (int i = 0; i < F.length; i++) {
//            System.out.println(F[i]);

//        }
        int[] a = {1, 2, 3};
        array(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
