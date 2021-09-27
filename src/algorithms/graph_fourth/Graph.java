package algorithms.graph_fourth;

import algorithms.first.Bag;

public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] bags;

    public Graph(int v){
        bags = new Bag[v];
        for (int i = 0; i < v; i++) {
            bags[i] = new Bag<Integer>();
        }
        this.V = v;
        this.E = 0;
    }

    public void addEdge(int s, int v){
        bags[s].add(v);
        bags[v].add(s);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return bags[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < V(); i++) {
            s = s + i + ":";
            for (Integer in : bags[i]) {
                s = s + " " + in;
            }
            s = s + "\n";
        }
        return s;
    }
}
