public class DIsjointSetUnion {
    
    static int n = 7;
    static int[] rank = new int[n];
    static int[] par = new int[n];
    public static void init(){
        for(int i = 0; i<par.length; i++){
            par[i] = i;
        }
    }
    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x] = find(par[x]);
    }
    public static void union(int x, int y){
        int parX = find(x);
        int parY = find(y);

        if(rank[parX]==rank[parY]){
            par[parY] = parX;
            rank[parX]++;
            return;
        }else if(rank[parX]>rank[parY]){
            par[parY] = parX;
            return;
        }
        par[parX] = parY;
    }
    public static void main(String[] args) {
        init();
        union(1, 2);
        union(3, 2);
        union(4, 1);
        System.out.println(find(3));
        System.out.println(find(4));
        for(int i =0; i<par.length; i++){
            System.out.println(i+": "+par[i]);
        }

        
    }
}
