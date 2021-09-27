package algorithms.graph_fourth;

import algorithms.first.Queue;
import algorithms.first.Stack;

public class BFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BFS(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        marked[s] = true;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (Integer w : G.adj(v)) {
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.enqueue(w);
                }
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
