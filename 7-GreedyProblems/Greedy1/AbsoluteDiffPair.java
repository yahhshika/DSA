package Greedy1;
import java.util.Arrays;

public class AbsoluteDiffPair {

    public static int absdiff(int a1[], int a2[]){
        Arrays.sort(a1);
        Arrays.sort(a2);
        int sum = 0;
        for(int i = 0; i<a1.length; i++){
            sum += Math.abs(a1[i]-a2[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] a1 = {1,2,5};
        int[] a2 = {2,1,3}; 
        System.out.println(absdiff(a1, a2)); //2

    
    } 
}
