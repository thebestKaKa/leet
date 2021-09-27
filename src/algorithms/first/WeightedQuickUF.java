package algorithms.first;

public class WeightedQuickUF {
    //并查集 加权quick-union
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUF(int N){
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        for (int j = 0; j < sz.length; j++) {
            sz[j] = 1;
        }
        count = N;
    }

    public int find_v3(int p){
        //加权quick-union
        while (p != id[p]) p = id[p];
        return p;
    }

    public int find_v4(int p){
        //加权quick-union 路径压缩
        int idx = p;
        while (p != id[p]) p = id[p];
        //路径压缩 直接跳到根节点
        while (idx != id[idx]){
            int temp = id[idx];
            id[idx] = p;
            idx = temp;
        }
        return p;
    }

    public void union_v3(int p, int q){
        //加权quick-union
        int pRoot = find_v3(p);
        int qRoot = find_v3(q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            //把p树连接到q树上 只修改了根节点 所以可以路径压缩修改非根节点
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    public boolean isConnected(int p, int q){
        return find_v3(p) == find_v3(q);
    }

    public int count(){
        return count;
    }
}
