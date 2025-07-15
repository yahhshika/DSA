import java.util.ArrayList;

//O(VE)
public class BellmanFord {
    static class Edge{
        int start;
        int dest; 
        int weight;
        Edge(int start, int dest, int weight){
            this.start = start;
            this.weight = weight;
            this.dest = dest;
        }
    }
    static class Info implements Comparable<Info>{
        int start; 
        int dist;
        Info(int start, int dist){
            this.start = start;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info i){
            return this.dist-i.dist;
        }
    }
    // relaxation : if(dist[u]+weight(u,v)<dist[v] then dist[v] = dist[u]+weight(u,v))
    // we have to go on each edge and we'll have to perform relaxation. we have to repeat this for v-1 times. thus we need three loops. 1st: for v-1 2nd for traversing the graph and 3rd for edges. 
    public static int[] bellmanFord(ArrayList<Edge>[] graph, int start){
        int[] dist = new int[graph.length];
        for(int i = 0; i<dist.length; i++){
            if(i==start){
                dist[i] = 0;
                continue;
            }
            dist[i] = Integer.MAX_VALUE;
        }
        // PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i =0; i<graph.length-1; i++){
            for(int vertex = 0; vertex<graph.length; vertex++){
                for(int j = 0; j<graph[vertex].size(); j++ ){
                    Edge currEdge = graph[vertex].get(j);
                    int u = currEdge.start;
                    int v = currEdge.dest;
                    int weight = currEdge.weight;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                        dist[v] = dist[u]+weight;
                    }
                }
            } 
        }
        

        return dist;
    }
    public static void main(String[] args){
//            (2)         (-1)      
//          -------> 1 <--------- 4 
//         |         |            ^ 
//         |         |            |                  
//  (start)0     (-4)|         (4)|      
//         |         |            |       
//         | (4)     v   (2)      |        
//          -------> 2 ---------> 3
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i = 0; i<graph.length;i++ ){
            graph[i] = new ArrayList<>();
        }

        // for 0:
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // for 1:
        graph[1].add(new Edge(1, 2, -4));
        
        // for 2:
        graph[2].add(new Edge(2, 3, 2));
        
        //for 3:
        graph[3].add(new Edge(3, 4, 4));

        //for 4:
        graph[4].add(new Edge(4, 1, -1));

        int[] dist = bellmanFord(graph, 0);
        for(int i =0; i<dist.length; i++){
            System.out.println(i+" - "+dist[i]);
        }
    }
}
