package dp6;

public class McmRecurMY {
    static class Matrix{
        int cost; //cost to form the matrix thru multiplication
        int rows; 
        int cols; //size formed will be rows x cols
        Matrix(int cost, int rows, int cols){
            this.cost = cost;
            this.rows = rows;
            this.cols = cols;
        }
    }
    public static Matrix mcmRec(int[] arr){
        int i = 1;
        int n = arr.length;
        int j = n-1; 
        // int k = i;
        return mcmRecUtil(arr, i , j);
    }
    public static Matrix mcmRecUtil(int[] arr, int i, int j){
        if(i == j){
            return new Matrix(0, arr[i-1], arr[i]);
        }
        if(i+1 == j){
            return new Matrix(arr[i-1]*arr[i]*arr[j], arr[i-1], arr[j]);
        }
        int cost = Integer.MAX_VALUE; 
        int rows = 0;
        int cols = 0;
        for(int k = i; k<j; k++){
            Matrix m1 = mcmRecUtil(arr, i, k);
            Matrix m2 = mcmRecUtil(arr, k+1, j);
            int localCost = m1.rows * m1.cols * m2.cols + m1.cost + m2.cost;
            if (localCost < cost) {
                cost = localCost;
                rows = m1.rows;
                cols = m2.cols;
            }
        }
        return new Matrix(cost, rows, cols);
        
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        Matrix m = mcmRec(arr);
        System.out.println(m.cost);
        System.out.println(m.rows);
        System.out.println(m.cols);
        
    }
}
