public class CountingSort {
    public static void countingSort(int[] arr){
        // int min = arr[0];
        int max = arr[0];
        for(int i = 0; i<arr.length; i++){
            // min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int count[] = new int[max+1];

        for(int i = 0; i<arr.length; i++){
            count[arr[i]]++;
        }

        int ind = 0;
        for(int i = 0; i<count.length; i++){
            while(count[i]!=0){
                arr[ind++] = i;
                count[i]--;
            }
        }
        return;

        


    }
    public static void main(String[] args) {
        int[]arr = {1,3,2,6,10,2,0,5,5,5,5,5,5};
        countingSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
