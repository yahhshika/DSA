import java.util.*;
public class Set {
    public static int countDistinct(int[] arr){
        if(arr.length==0){
            return -1;
        }
        if(arr.length==1){
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            set.add(arr[i]);
        }
        return set.size();
    }
    public static HashSet<Integer> unionOfSets(HashSet<Integer> set1, HashSet<Integer>set2 ){
        HashSet<Integer> ansSet = new HashSet<>();
        Iterator it = set1.iterator();
        for(Integer i: set1){
            ansSet.add(i);
        }
        for(Integer i: set2){
            ansSet.add(i);
        }
        return ansSet;

        
    }
    public static HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer>set2){
        HashSet<Integer> ansSet = new HashSet<>();
        for(Integer i: set1){
            if(set2.contains(i)){
                ansSet.add(i);
            }
        }
        return ansSet;
    }
    public static ArrayList<String> getItenary(HashMap<String,String> map){
        if(map.size()==0){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> to = new HashSet<>();
        HashSet<String> from = new HashSet<>();
        String start = "";
        for(HashMap.Entry<String,String> entry: map.entrySet()){
            from.add(entry.getKey());
            to.add(entry.getValue());
        } 
        for(String key: from){
            if(!to.contains(key)){
                start = key;
            }
        }
        list.add(start);
        while(map.get(start)!=null){
            start = map.get(start);
            list.add(start);

        }
        

        return list;
    }
    public static int maxSubArrayWithSumZero(int[]arr){
        if(arr.length == 1 && arr[0]!=0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int stind =-1, endind = -1;
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                int i = map.get(sum);
                stind = i+1;
                endind = j;
            }else{
                map.put(sum,j);
            }
        }
        System.out.println("start index: "+stind+" end index: "+endind); 
        return endind - stind +1;
    }
    public static int maxSubArrayWithSumK(int[] arr, int k){
        if(arr.length==1 && arr[0]!=k){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int stind = -1;
        int endind = -1;
        for(int j = 0; j<arr.length; j++){
            sum += arr[j]; 
            if(map.containsKey(sum-k)){
                stind = map.get(sum-k)+1;
                endind = j;
            }
            map.put(sum,j);
        }
        return endind-stind+1;

    }
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,4,5,6,7,7,7,8,1};
        // System.out.println(countDistinct(arr));
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(2);
        set1.add(4);
        set1.add(5);
        set1.add(5);
        
        set2.add(1);
        set2.add(10);
        set2.add(20);
        set2.add(4);
        set2.add(5);
        // union: 1 ,2,4,5,10,20 intersection: 1,4,5
        // System.out.println(unionOfSets(set1, set2));
        // System.out.println(intersection(set1, set2));

        HashMap<String,String> map = new HashMap<>();
        map.put("Chennai","Bengaluru");
        map.put("Mumbai","Delhi");
        map.put("Goa","Chennai");
        map.put("Delhi","Goa");
        // System.out.println(getItenary(map));

        int[] sumArr = {15,-2,2,-8,1,7,-15,23};
        System.out.println(maxSubArrayWithSumZero(sumArr));


    }
}