package algorithms.graph_fourth;

public class TwoColor {
    //检查二分图
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor = true;

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (Integer n : G.adj(v)) {
            if (!marked[n]){
                color[n] = !color[v];
                dfs(G, n);
            }else if (color[n] == color[v])isTwoColor = false;
        }
    }

    public boolean isTwoColor(){
        return isTwoColor;
    }
}
