package dp6;

public class McmRecurDIDI {
    public static int mcmRecur(int []arr, int i, int j){
        if(i==j){
            return 0;
        }
        int cost = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int cost1 = mcmRecur(arr, i, k);
            int cost2 = mcmRecur(arr, k+1, j);
            int localcost = cost1 + cost2 + arr[i-1]*arr[k]*arr[j];
            cost = Math.min(localcost, cost);
        }
        return cost;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println(mcmRecur(arr, 1, arr.length-1));
        
        
    }
}
