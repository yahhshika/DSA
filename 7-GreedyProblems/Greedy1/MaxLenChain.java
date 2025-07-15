package Greedy1;
import java.util.Arrays;
import java.util.Comparator;
public class MaxLenChain {
    public static int maxLen(int[][]pairs){
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));

        int count =1;
        int lastend = pairs[0][1];
        for(int i = 1; i<pairs.length; i++){
            if(pairs[i][0]>lastend){
                lastend = pairs[i][1];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] pairs ={{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};
        System.out.println(maxLen(pairs));
    }
}
