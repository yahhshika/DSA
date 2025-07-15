import java.util.ArrayList;
import java.util.PriorityQueue;


//O(V + ELogV);
public class Dijkistra {
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
    static class Info implements Comparable<Info>{
        int start;
        int dist;
        Info(int data){
            this.start = data;
            this.dist = Integer.MAX_VALUE;
        } 
        Info(int data, int dist){
            this.start = data;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info i){
            return this.dist - i.dist;
        }

    }
    public static int[] dijkistraALgo(ArrayList<Edge>[] graph, int source){
        int[] dist = new int[graph.length];
        for(int i =0; i<dist.length; i++){
            if(i==source){
                dist[i] = 0;
                continue;
            }
            dist[i] = Integer.MAX_VALUE;
        }
        boolean isVisited[] = new boolean[graph.length];
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(source, 0));
        while(!pq.isEmpty()){
            Info curr = pq.remove();
            if(!isVisited[curr.start]){
                for(int i = 0; i<graph[curr.start].size(); i++){
                    Edge curEdge = graph[curr.start].get(i);
                    int u = curEdge.start;
                    int v = curEdge.end;
                    int weight = curEdge.weight;
                    if(dist[u]+weight<dist[v]){
                        dist[v] = dist[u]+weight;
                        pq.add(new Info(v,dist[v]));
                    }
                }
            }

        }
        return dist;        

    }
  

    public static void main(String args[]){
//            (2)         (7)           (1)
//          -------> 1 ---------> 3 -------
//         |         |            ^        |
//         |         |            |        v          
//  (start)0      (1)|         (2)|        5 (end)
//         |         |            |        ^        
//         | (4)     v   (3)      |        | (5)
//          -------> 2 ---------> 4 -------

        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new  ArrayList[v];
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        } 
        // for 0: 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // for1: 2
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        
        // for 2: 3
        graph[2].add(new Edge(2, 4, 3));

        //for 3: 8
        graph[3].add(new Edge(3, 5, 1));

        //for 4: 6
        graph[4].add(new Edge(4, 5, 5));
        graph[4].add(new Edge(4, 3, 2));

        //for 5: 9
        // no edges. 
        int[]dist = dijkistraALgo(graph, 0);
        for(int i =0; i<dist.length; i++){
            System.out.println(i+" : "+dist[i]);
        }


    } 
}
