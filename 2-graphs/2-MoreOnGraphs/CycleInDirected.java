import java.util.ArrayList;

public class CycleInDirected {
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
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        boolean []stack = new boolean[graph.length];
        
        for(int i = 0; i<graph.length; i++){
            if(!isVisited[i]){
                boolean result = detectCycleUtil(graph, i, isVisited, stack);
                
                if(result){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int start, boolean isVisited[], boolean []stack){
        isVisited[start] = true;
        stack[start] = true;
        for(int i = 0; i<graph[start].size(); i++){
            Edge currEdge = graph[start].get(i);
            if(stack[currEdge.end]){
                return true;
            }
            else if(!isVisited[currEdge.end]){
                boolean result = detectCycleUtil(graph, currEdge.end, isVisited, stack);
                if(result){
                    return true;
                }
            }
            // stack[currEdge.end] = false;
        }
        stack[start] = false;
        return false;
    }
    public static void main(String[] args) {
//                            
//                            
//                            
//     graph1:   0 ---------> 1 <-------
//                           /           |
//                          /            |
//                         /             |
//                         ---->2------->3
//                      
// 
// 
//    
        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[v];
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // for 0:
        graph[0].add(new Edge(0, 1, 1));
        // for 1:
        graph[1].add(new Edge(1, 2, 1));
        // for 2:
        graph[2].add(new Edge(2, 3, 1));
        // for 3:
        graph[3].add(new Edge(3, 1, 1));

        System.out.println(detectCycle(graph));
    }
}
