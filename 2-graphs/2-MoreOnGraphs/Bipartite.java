import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Bipartite {
    static class Edge{
        int start;
        int end;
        int weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        // boolean isVisited[] new boolean[graph.length];
        int[] color = new int[graph.length];
        for(int i =0; i<color.length; i++){
            color[i] = -1;
        }
        for(int i = 0; i<graph.length; i++){
            if(color[i]==-1){
                boolean result = isBipartiteUtil(graph, i, color);
                if(!result){
                    return false;
                }
                
                    
            }

        }
        return true;
    }
    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int start, int[]color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.println("curr and it's color: "+curr+","+color[curr]);
            for(int i = 0; i<graph[curr].size(); i++){
                Edge curEdge = graph[curr].get(i);
                System.out.println("curEdge: "+curEdge.end);
                if(color[curEdge.end] == -1){ //color not assigned yet. 
                    if(color[curr] == 0){
                        color[curEdge.end] = 1;
                        System.out.println("color assigned: "+color[curEdge.end]);
                    }else{
                        color[curEdge.end] = 0;
                        System.out.println("color assigned: "+color[curEdge.end]);
                        
                        
                    }
                    System.out.println("putting into queue:");
                    q.add(curEdge.end);
                    System.out.println("q now: "+q);
                   
                }
                else if(color[curEdge.end] != -1){
                    if(color[curEdge.end]==color[curr]){
                        System.out.println("same color are curr. return false");
                        return false;
                    }
                    
                }
                
            }
        }
        return true;

    }
    public static void main(String[] args){

//        -- 0 --
//      /         \
//     /           \
//    1             2
//     \           /
//      \         /
//        3 ---- 4

        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[v];

        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // for 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // for 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // for 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // for 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        // for 4
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 2, 1));

        System.out.println(isBipartite(graph));
        
    }
}
