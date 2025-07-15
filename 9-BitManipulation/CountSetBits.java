public class CountSetBits {
    public static int cntSetBits(int n){
        int count = 0;
        while(n!=0){
            int ans = n & 1;
            if(ans == 1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(cntSetBits(5)); // 00000101 => 2
        System.out.println(cntSetBits(15)); // 00001111 => 4

        
    }
}
