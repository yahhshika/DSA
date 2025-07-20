public class BackTrackArray {
// task : traverse till the end in array and update arr[i] = i; and while backtracking do arr[i]++;
    public static void backtracking(int arr[], int ind){
        if(ind == arr.length){
            return;
        }
        arr[ind] = ind;
        backtracking(arr, ind+1);
        arr[ind]++; 
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        backtracking(arr, 0);
        for(int i : arr){
            System.out.println(i);
        }

        
    }
}