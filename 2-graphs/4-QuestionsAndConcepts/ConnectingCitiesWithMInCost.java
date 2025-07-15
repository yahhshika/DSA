import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMInCost {
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
        int cost; 
        Info(int start, int cost){
            this.start = start;
            this.cost = cost;
        }
        @Override
        public int compareTo(Info i){
            return this.cost - i.cost;
        }

    }
    public static void initGraph(ArrayList<Edge>[] graph, int[][]cities){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<cities.length; i++){
            for(int j = 0; j<cities[i].length; j++){
                int start = i;
                int end = j;
                int weight = cities[i][j];
                if(weight==0){
                    continue;
                }
                graph[start].add(new Edge(start, end, weight));
            }
        }
    }
    public static int connectingCitiesMST(int[][] cities ){
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[cities.length];
        initGraph(graph, cities);
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[cities.length];
        int cost = 0;
        pq.add(new Info(0,0));
        while(!pq.isEmpty()){
            Info curr = pq.remove();
            if(!isVisited[curr.start]){
                isVisited[curr.start] = true;
                cost += curr.cost;
                for(int i= 0; i<graph[curr.start].size(); i++){
                    Edge curEdge = graph[curr.start].get(i);
                    pq.add(new Info(curEdge.end, curEdge.weight));
                }
            }
        }
        for(int i = 0; i<isVisited.length; i++){
            System.out.println(i+":"+isVisited[i]);
        }
        return cost;
    }
    public static void main(String[] args) {
        int[][] cities= {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        System.out.println(connectingCitiesMST(cities));

        
    }
}
