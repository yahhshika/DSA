public class InsertionSort {
    public static void insertionSort(int[]arr){
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            for(int j = i; j<n; j++){
                int pos = j-1;
                int temp = arr[j];
                while(pos>=0 && arr[pos]>temp){
                    arr[j] = arr[pos];
                    pos--;
                }
                arr[++pos] = temp;
                
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,7,2,10,6};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
