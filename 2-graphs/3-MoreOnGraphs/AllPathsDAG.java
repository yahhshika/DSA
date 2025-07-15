import java.util.ArrayList;

public class AllPathsDAG {
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
    public static void getPaths(ArrayList<Edge>[] graph, String path, int start, int end){
        path+=start;
        for(int i = 0; i<graph[start].size(); i++){
            Edge curr = graph[start].get(i);
            if(curr.end == end){
                System.out.println(path+end);

            }
            else{
                getPaths(graph,path, curr.end, end);
                
            }
        }
    }
    public static void main(String[] args) {
//     5 ----------> 0 <-------------- 4
//     |             |                 |
//     |             |                 |
//     |            \/                 |
//      ---> 2  ---> 3 ---------> 1 <--




        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // for 0:
        graph[0].add(new Edge(0, 3, 1));
        
        // for 1:

        // for 2:
        graph[2].add(new Edge(2, 3, 1));
        // for 3:
        graph[3].add(new Edge(3, 1, 1));
        // for 4:
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        // for 5:
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));   

        getPaths(graph,"", 5, 1);
        
       
    }
    
}
