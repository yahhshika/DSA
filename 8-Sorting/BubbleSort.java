public class BubbleSort {
// space - O(1) time- O(n2) (worst)
    public static void bubbleSort(int[]arr){ //optimised bubble sort. 
        int n = arr.length;
        boolean exchange = false;
        for(int i = 0; i<n-1; i++){
            for(int j = 0; j<n-1-i; j++){
                // exchange:
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    exchange = true;
                }

            }
            if(!exchange){
                System.out.println("no exchange held at i= "+i);
                return;
            }else{
                exchange = false;
            }
        }
    }
    public static void main(String[] args) {
        // int[] arr = {3,4,2,1,7,8,10};
        int[]arr = {5,1,2,3,4};
        bubbleSort(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }
}