package algorithms.graph_fourth;

public class DFS {
    private boolean[] marked;
    private int count;

    public DFS(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s){
        marked[s] = true;
        count++;
        for (Integer v : G.adj(s)) {
            if (!marked[v])dfs(G, v);
        }
    }

    public boolean isMarked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }
}
