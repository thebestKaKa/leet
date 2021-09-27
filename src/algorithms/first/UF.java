package algorithms.first;

public class UF {
    //并查集
    private int[] id;
    private int count;

    public UF(int N){
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        count = N;
    }

    public int find_v1(int p){
        //quick-find
        return id[p];
    }

    public void union_v1(int p, int q){
        //quick-find
        if (id[p] == id[q]) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p]) id[i] = id[q];
        }
        count--;
    }

    public int find_v2(int p){
        //quick-union
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union_v2(int p, int q){
        //quick-union
        int pRoot = find_v2(p);
        int qRoot = find_v2(q);
        if (pRoot == qRoot) return;
        //id[pRoot] = id[qRoot];
        id[pRoot] = qRoot;
        count--;
    }

    public boolean isConnected(int p, int q){
        return find_v1(p) == find_v1(q);
    }

    public int count(){
        return count;
    }
}
