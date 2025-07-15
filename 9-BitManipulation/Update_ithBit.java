public class Update_ithBit {
    public static int clear_ith(int n, int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }
    public static int setIth(int n, int i){
        int bitmask = 1<<i;
        return n | bitmask;
    }
    public static int updateIth(int n, int i, int val){
        if(val == 0){
            return clear_ith(n, i);
        }
        return setIth(n, i);
    }
    public static void main(String[] args) {
        System.out.println(updateIth(15, 0, 0)); // 1111 -> ans ->1110 (14)
        System.out.println(updateIth(13, 1 , 1)); //1101 -> ans -> 1111 (15)
        
    }
}
