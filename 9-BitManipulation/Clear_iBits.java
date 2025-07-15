public class Clear_iBits {
    public static int clear_iBits(int n, int i){
        int bitmask = ~0 << i;
        return n & bitmask;
    }
    public static void main(String[] args) {
        System.out.println(clear_iBits(15,3));
        // 1111 (15)
        // 1100 (12)
        
    }
}
