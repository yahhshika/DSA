public class Clear_range {
    public static int clear_range(int n, int j, int i){  //ith bit to jth bit
        int bitmask1 = (~0)<<(j+1);
        int bitmask2 = (1<<i)-1;
        int bitmask = bitmask1 | bitmask2;
        return n & bitmask;
    }
    public static void main(String[] args) {

        System.out.println(clear_range(10, 4, 2)); //2
        // 00001010 is 10
        // 00000010 is 2
        
    }
}
