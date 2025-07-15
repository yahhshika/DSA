package Greedy1;

import java.util.Arrays;
// import java.util.Comparator;

public class FractionalKnapSack {
    public static double knapSack(int[] wt, int[] val, int w){
        if(w==0){
            return 0;
        }
        double[][] knapSack = new double[val.length][2];
        for(int i = 0; i<knapSack.length; i++){
            knapSack[i][0] = i;
            knapSack[i][1] = val[i]/(double)wt[i];
        }

        // Arrays.sort(knapSack, Comparator.comparingDouble(o->o[1]));
        // Arrays.sort(knapSack, Comparator.comparingDouble(o -> o[1]).reversed());
        Arrays.sort(knapSack, (a, b) -> Double.compare(b[1], a[1]));
        double profit = 0; 

        for(int i = 0; i<knapSack.length; i++){
            int curInd = (int) knapSack[i][0];
            if(w >= wt[curInd]){ // valid
                w -= wt[curInd];
                profit += val[curInd]; 
            }
            else{
                profit += knapSack[i][1]*w;
                w = 0;
                break;
            }
        }
        return profit;

    }
    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] wt = {10,20,30};
        int W = 50;
        System.out.println(knapSack(wt, val, W));
        
    }
}
