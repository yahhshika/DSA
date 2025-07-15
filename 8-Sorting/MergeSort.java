public class MergeSort {
    public static void divide(int[]arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si +(ei-si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        merge(arr, si, mid, ei);
        System.out.println("sorted: ");
        for(int i = si; i<=ei; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void merge(int[]arr, int si,int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si; //iterator for left part
        int j = mid+1; //iterator for right part

        int ind = 0; // iterator for temp;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[ind++] = arr[i++]; 
            }else{
                temp[ind++] = arr[j++];
            }
        }
        while(j<=ei){
            temp[ind++] = arr[j++]; 
        }
        while(i<=mid){
            temp[ind++] = arr[i++];
        }

        ind = 0;
        for(int k = si; k<=ei; k++){
            arr[k] = temp[ind++];
        }
    }
    public static void main(String[] args) {
        int[]arr = {1,3,2,6,10,2,0,100,1000,-123};
        divide(arr, 0, arr.length-1);
        System.out.println("final: ");
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
