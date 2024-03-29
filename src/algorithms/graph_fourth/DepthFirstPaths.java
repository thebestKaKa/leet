package algorithms.graph_fourth;

import algorithms.first.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int s){
        marked[s] = true;
        for (Integer v : G.adj(s)) {
            if (!marked[v]){
                edgeTo[v] = s;
                dfs(G, v);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v))return null;
        Stack<Integer> stack = new Stack();
        for (int w = v; w != s; w = edgeTo[v]){
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
}
