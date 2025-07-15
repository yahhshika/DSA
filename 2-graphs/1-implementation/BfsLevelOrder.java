import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// 2 => bfs, dfs, hasPath

public class BfsLevelOrder {
 
    public static void graphInit(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++ ){
            graph[i] = new ArrayList<>();
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int start, int end, boolean isVisited[]){
        isVisited[start] = true;
        boolean result = false;
        for(int i = 0; i<graph[start].size(); i++){
            int curr = graph[start].get(i).end;
            if(curr == end){
                return true;
            }
            else if(!isVisited[curr]){
                result =  hasPath(graph, curr, end, isVisited);
                if(result){
                    return result;
                }
            }
        }
        return result;
    }
    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!isVisited[i]){
                System.out.println("call made for"+i);
                dfsUtil(graph, i, isVisited);
            } //couldnt work without if conditions
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph, int start, boolean isVisited[]){
        System.out.println(start);
        isVisited[start] = true;
        for(int i = 0; i<graph[start].size(); i++){
            if(!isVisited[graph[start].get(i).end]){
                dfsUtil(graph,graph[start].get(i).end , isVisited);
            }
        }   
    }
    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        for(int i =0; i<graph.length; i++){
            // if(!isVisited[i]){
                // System.out.println("call made for "+i);
                bfsUtil(graph, isVisited, i);
            // } //works without if condition
        }
    }
    
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean isVisited[], int start){

        Queue<Integer> q = new LinkedList<>();
        // boolean[] isVisited = new boolean[graph.length];

        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!isVisited[curr]){
                for(int i = 0; i<graph[curr].size(); i++){
                    if(!isVisited[graph[curr].get(i).end]){

                        q.add(graph[curr].get(i).end);
                    }
                }
                System.out.println(curr);
                isVisited[curr] =true;
            }
            
        }
// out of queue   0  1 2 0  3 0 4 1 4 3 5 6 6 3 4 5 | queue====now empty
// curr = 0, 1 2 0 3 0 4 1 4 3 5 6 6 3 4 5
// {0true, true1,true2,true3,true4,true5,true6}
// 0 1 2 3 4 5 6
        

// 0 1  2  3 4 5 6 |
//curr = 0 1 2 3 4 5 6
//{true0,true1,true2,true3,true4,true5,true6}
//o/p=> 0 1 2 3 4 5 6






        // (1 )
        // curr = 1
        // 0
        // is = [0true, 1,2,3,4,5,6]


    }
    public static void main(String[] args) {
        
        //        1-------------3
        //       /              | \
        //      /               |  \
        //     0                |   5
        //      \               |  / \       7-----8
        //       \              | /   \
        //        2-------------4      6

        int v = 9;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[v];
        graphInit(graph);
        
        // for 0:
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        //for 1:
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // for 2:
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // for 3:
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3,4 , 1));

        // for 4:
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));

        // for 5:
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

        // for 6:
        graph[6].add(new Edge(6, 5, 1));


        //for 7:
        graph[7].add(new Edge(7, 8, 1));

        //for 8:
        graph[8].add(new Edge(8, 7, 1));

        // bfs(graph);
        // boolean[] isVisited = new boolean[graph.length];
        // System.out.println( hasPath(graph, 0, 3, isVisited));
        // dfs(graph);
        bfs(graph);


        

    }

}
