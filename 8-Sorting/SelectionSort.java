public class SelectionSort {
    public static void insetionSort(int[]arr){
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            int smallest = i;
            for(int j = i; j<n; j++){
                if(arr[j]<arr[smallest]){
                    smallest = j;
                }
            }
            if(smallest != i){
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
            }


        }
    }
    public static void main(String[] args) {
        int[]arr = {1,3,2,6,10,2,0};
        insetionSort(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }
}
