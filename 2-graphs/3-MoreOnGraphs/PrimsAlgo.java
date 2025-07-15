import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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
        int start ; 
        int dist ;
        Info(int start, int dist){
            this.start = start;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info i){
            return this.dist - i.dist;
        }
        
    }
    public static int primsAlgo(ArrayList<Edge>[] graph){
        int cost = 0;
        // int start = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[graph.length];
        pq.add(new Info(0 , 0));

        while(!pq.isEmpty()){
            Info curr = pq.remove();
            if(!isVisited[curr.start]){
                isVisited[curr.start] = true;
                cost += curr.dist;
                for(int i =0; i<graph[curr.start].size(); i++){
                    Edge curEdge = graph[curr.start].get(i);
                    pq.add(new Info(curEdge.end, curEdge.weight));
                }
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


        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // 0:
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 30));
        
        //1:
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 40));

        //2:
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 1, 40));
        graph[2].add(new Edge(2, 3, 50));

        //3:
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));

        System.out.println(primsAlgo(graph));
    }
}