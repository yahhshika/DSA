package Greedy1;

import java.util.Comparator;
import java.util.Arrays;
public class ActivitySelectionProb {
    //sorted according to end time
    public static void actSelect(int[] start, int[]end){

        // int laststart = start[0];
        int lastend = end[0];
        System.out.print("A"+0+" ");
        for(int i = 1; i<start.length; i++){
            int curStart = start[i];
            if(curStart>=lastend){
                System.out.print("A"+i+" ");
                // laststart = curStart;
                lastend = end[i];
            }
        }
        System.out.println();
    }

    public static void actSelectUnsorted(int[] start, int[] end){
        int[][] activity = new int[start.length][3];
        for(int i = 0; i<activity.length; i++){
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        Arrays.sort(activity, Comparator.comparingDouble(o->o[2]));

        int lastend = activity[0][2];
        System.out.print("A"+0+" ");
        for(int i = 1; i<activity.length; i++){
            if(activity[i][1]>=lastend){
                lastend = activity[i][2];
                System.out.print("A"+activity[i][0]+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // int[]start = {10,12,20};
        int[]start = {1,0,5,8,5,3};
        // int[] end = {20,25,30};
        int[] end = {2,6,7,9,9,4};
        // actSelect(start, end);
        actSelectUnsorted(start, end);
        
    }
    
}