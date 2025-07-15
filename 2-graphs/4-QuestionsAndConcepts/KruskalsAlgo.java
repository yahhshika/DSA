
// using disjointSetUnion Algo
// step1: sort the edges based on the weights
// step2: keep including edges till the included edges are not = v-1;
// step3: while includind an edge check if it forms a cycle. if cycle is formed in adding edge x->y then par[x] == par[y]

import java.util.ArrayList;
import java.util.Collections;


// O(V+ELogE)
public class KruskalsAlgo {
    static class Edge implements Comparable<Edge>{
        int start; 
        int end;
        int weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    static int n = 4;
    static int[] rank = new int[n];
    static int[] par = new int[n];
    public static void init(){
        for(int i = 0; i<par.length; i++){
            par[i] = i;
        }
    }
    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x] = find(par[x]);
    }
    public static void union(int x, int y){
        int parX = find(x);
        int parY = find(y);

        if(rank[parX]==rank[parY]){
            par[parY] = parX;
            rank[parX]++;
            return;
        }else if(rank[parX]>rank[parY]){
            par[parY] = parX;
            return;
        }
        par[parX] = parY;
    }
    public static int kruskalAlgo(ArrayList<Edge> graph, int v){
        init();
        int cost = 0;
        int count = 0;
        Collections.sort(graph);
        for(int i =0; count<v-1; i++){
            Edge e = graph.get(i);
            int start = e.start;
            int end = e.end;
            int parS = find(start);
            int parE = find(end);
            if(parE!=parS){
                union(start, end);
                count++;
                cost += e.weight;
            } 

        }
        return cost;

    }
    public static void main(String[] args) {
//             
//            -- 0 --
//          /    |    \
//    (10) /     |     \ (30)                   
//        1  (15)|      3
//   (40)  \     |     / (50)    
//          \    |    /                    
//            -- 2 --                  

        // init();
        // int v = 4;
        // @SuppressWarnings("unchecked")
        ArrayList<Edge> graph = new ArrayList<>();

  
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(1, 2, 40));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(3, 2, 50));

        System.out.println(kruskalAlgo(graph, 4));
    }
    
}
