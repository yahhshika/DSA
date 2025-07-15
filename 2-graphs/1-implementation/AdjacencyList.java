import java.util.ArrayList;
// import BfsLevelOrder.Edge;


//  1

public class AdjacencyList {
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
    public static void main(String[] args) {
        //            (5)
        //        0-----------1
        //                  /   \
        //             (1) /     \ (3)
        //                /       \
        //               2 ------- 3
        //               |     (1)
        //           (2) |
        //               4

        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v]; //this means that at every index of the graph null is stored but that null doesnt mean that there is an arraylist which is currently null; it simply means just null, thus we'll have to initilize every index with an empty arraylist first. 

        for(int i =0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        // list for 0:
        graph[0].add(new Edge(0, 1, 5));
        // list for 1:
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // list for 2:
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // list for 3:
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // finding neighbours:
        for(int i =0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.end+" is the end node for 2 with weight: "+e.weight);
        }
    
    }
}