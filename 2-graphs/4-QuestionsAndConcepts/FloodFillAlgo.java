public class FloodFillAlgo {
    public static void floodfillHelper(int[][] pixel, boolean[][] isVisited ,int sr, int sc, int color, int old){
        if(sc>=pixel[0].length || sr>=pixel.length || isVisited[sr][sc]  || sr<0 || sc<0 || old!=pixel[sr][sc]){
            return;
        }

        pixel[sr][sc] = color;
        isVisited[sr][sc] = true;
        // System.out.println(old);
        floodfillHelper(pixel,isVisited, sr-1, sc, color, old);
        floodfillHelper(pixel,isVisited, sr+1, sc, color, old);
        floodfillHelper(pixel,isVisited, sr, sc-1, color, old);
        floodfillHelper(pixel,isVisited, sr, sc+1, color, old);

    }
    public static int[][] floodfill(int[][]pixel, int sr, int sc, int color){
        boolean[][] isVisited = new boolean[pixel.length][pixel[0].length];
        floodfillHelper(pixel, isVisited, sr, sc, color, pixel[sr][sc]);
        return pixel;

    }
    public static void main(String[] args) {
        int[][] pixel = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
       
        floodfill(pixel, 1, 1,2);

        for(int i= 0; i<pixel.length; i++){
            for(int j = 0; j<pixel[i].length; j++){
                System.out.print(pixel[i][j]+" ");
            }
            System.out.println();
        }

    }
}
