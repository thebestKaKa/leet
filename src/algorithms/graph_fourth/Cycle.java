package algorithms.graph_fourth;

public class Cycle {
    //检查环
    private boolean[] marked;
    private boolean isCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph G, int v, int w){
        marked[v] = true;
        for (Integer n : G.adj(v)) {
            if (!marked[n]){
                dfs(G, n, v);
            }else if (n != w)isCycle = true;
        }
    }

    public boolean isCycle(){
        return isCycle;
    }

}
