public class Clear_ithBit {
    public static int clear_ith(int n, int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }
    public static void main(String[] args) {
        System.out.println(clear_ith(10, 3));
        // 10 : 1010
        // clear 3rd: 0010: 2  
    }
}
