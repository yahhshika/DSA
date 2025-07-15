import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class TopologicalSorting {
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
    /* using dfs:  */
    public static void topologicalSort(ArrayList<Edge> [] graph){
        boolean[] isVisited = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<graph.length; i++){
            if(!isVisited[i]){
                topologicalSortUtil(graph, isVisited,i, st);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println();
    }
    public static void topologicalSortUtil(ArrayList<Edge> [] graph, boolean[] isVisited,int start, Stack<Integer> st){
        isVisited[start] = true;
        for(int i =0; i<graph[start].size(); i++){
            if(!isVisited[graph[start].get(i).end]){
                topologicalSortUtil(graph, isVisited, graph[start].get(i).end, st);
            }
        }
        st.push(start);
    }
    /* using bfs: */
    public static void getIndegree(ArrayList<Edge>[] graph, int[] inDegree){
        for(int i =0; i < graph.length; i++){
            for(int j = 0; j<graph[i].size(); j++){
                inDegree[graph[i].get(j).end]++;
            }
        }
    }
    // kahn's algo 
    public static void topologicalSortBfs(ArrayList<Edge>[] graph){
        int inDegree[] = new int[graph.length];
        getIndegree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<inDegree.length; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i = 0; i<graph[curr].size(); i++){
                Edge curEdge = graph[curr].get(i);
                inDegree[curEdge.end]--;
                if(inDegree[curEdge.end]==0){
                    q.add(curEdge.end);
                }
            }
        }
        System.out.println();

    }
    public static void main(String []args){
//     5 ----------> 0 <-------------- 4
//     |                               |
//     |                               |
//      ---> 2  ---> 3 ---------> 1 <--


        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // for 0:
        
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

        topologicalSort(graph);
        topologicalSortBfs(graph);
    }

}
