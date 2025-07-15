import java.util.ArrayList;
// import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// There are  cities connected by some number of flights. you are given an srray flight where flight[i] = [to, from, price] indicates that there is a flight. 
// you are also given three integers src, dst and k. return the cheapest price form source to destination with atmost k stops. 
public class CheapestFlightRoute {
    static class Edge{
        int start;
        int end; 
        int cost; 
        Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static class Info{
        int start; 
        int price; //not the weight of an edge but the total price of an vertex from start till the vertex
        int steps; // how many vetices have been travelled to reach this vertex. eg 1->2->3 steps(1) = 0, for2 it is 1 and for 3 it is 2. 
        Info(int start,int price,int steps){
            this.start = start;
            this.price = price;
            this.steps = steps;
        }


    }
    public static void initGraph(int[][]flight, ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        for(int i =0; i<flight.length; i++){
            int start = flight[i][0];
            int dest = flight[i][1];
            int cost = flight[i][2];
            graph[start].add(new Edge(start, dest, cost));
        }

    }
    public static int getMinCost(ArrayList<Edge>[] graph, int src, int dest, int k){
        int[] dist = new int[graph.length];
        // Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i<dist.length; i++){
            if(i == src){
                dist[i] = 0;
                continue;
            }
            dist[i] = Integer.MAX_VALUE;
        }
        boolean[] isVisited = new boolean[graph.length];
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info cur = q.remove();
            if(!isVisited[cur.start]){
                isVisited[cur.start] = true;
                if(cur.steps>k){
                    System.out.println("breaking at: "+cur.start);
                    break;
                }
                for(int i = 0; i<graph[cur.start].size(); i++){
                    int steps = cur.steps+1;
                    // int u = cur.start;
                    int v = graph[cur.start].get(i).end;
                    int cost = graph[cur.start].get(i).cost;
                    if(cur.price+cost<dist[v] && cur.start<=k){
                        dist[v] = cur.price+cost;
                    }
                    q.add(new Info(v, dist[v], steps));
                }
            }

        }System.out.println("dist:");
        for(int i = 0; i<dist.length; i++){
            System.out.println(i+":-"+dist[i]);
        }
        System.out.println("isVisited: ");
        for(int i = 0; i<isVisited.length; i++){
            System.out.println(i+":-"+isVisited[i]);
        }

        
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dest];
    }
    public static void main(String [] args){
        int n = 5;
        int[][] flight = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600},{2,3,200},{3,4,10}};
        // int[][] flight = {{0,1,10},{0,4,100},{4,3,200},{1,2,20},{2,3,10}};
        int src = 0;
        int dest = 2;
        // int dest = 3;
        int k = 1;
        // int k = 2;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        initGraph(flight, graph);

        int ans = getMinCost(graph, src, dest, k);
        System.out.println(ans);  
    }
}
