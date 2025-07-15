import java.util.ArrayList;


// 3

public class cycleInGraph {
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

    public static boolean dfsDetectCycle(ArrayList<Edge> [] graph){
        boolean[] isVisited = new boolean[graph.length];
        boolean result = false;
        for(int i= 0; i<graph.length; i++){
            if(!isVisited[i]){
                result = dfsUtil(graph, isVisited, i, i);
                if(result){return result;}
            }
        }
        return result;

    }



    public static boolean dfsUtil(ArrayList<Edge>[] graph, boolean[] isVisited, int start, int parent){
        isVisited[start] = true;
        // boolean result = false;
        for(int i = 0; i<graph[start].size(); i++){
            int curr = graph[start].get(i).end;
            if(isVisited[curr] && curr!=parent){
                System.out.println("returning true for: "+start+ "in section 1");
                return true;
            }else if(!isVisited[curr] && dfsUtil(graph, isVisited, curr, start)){
                System.out.println("returning true for: "+start+ "in section 2");
                
                return true;
            }
        }
        return false;

    }
    
    public static void main(String[] args) {
//         0 -------- 3            5
//      /  |                    /      \   
//     /   |                   /        \   
//    1    |                  /          \
//     \   |                6  ---------- 7
//      \  | 
//         2 -------- 4
//
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i = 0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        //for 0:
        graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        // for 1:
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        //for 2:
        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 1));
        // for 3:
        graph[3].add(new Edge(3, 0, 1));
        // for 4:
        graph[4].add(new Edge(4,2,1));
        //for 5:
        // graph[5].add(new Edge(5, 6, 1));
        // graph[5].add(new Edge(5, 7, 1));
        // //for 6:
        // graph[6].add(new Edge(6, 5, 1));
        // graph[6].add(new Edge(6, 7, 1));
        // //for 7:
        // graph[7].add(new Edge(7, 5, 1));
        // graph[7].add(new Edge(7, 6, 1));

        System.out.println(dfsDetectCycle(graph));


    }
}
