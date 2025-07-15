public class Set_ithBIt {
    public static int setIth(int n, int i){
        int bitmask = 1<<i;
        return n | bitmask;
    }
    public static void main(String[] args) {
        System.out.println(setIth(5, 3));


        // 5: 0101
        // set 3rd bit: 1101: 13
        
    }
}
