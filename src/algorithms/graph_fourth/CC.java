package algorithms.graph_fourth;

public class CC {
    //连通分量（dfs）
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]){
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(Graph G, int s){
        marked[s] = true;
        id[s] = count;
        for (Integer v : G.adj(s)) {
            if (!marked[v]){
                dfs(G, v);
            }
        }
    }

    public boolean isConnected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public boolean isMarked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }
}
