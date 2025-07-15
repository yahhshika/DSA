public class Get_ithBit {
    public static int getIth(int n, int ith){
        int bitmask = 1<<ith;
        // return (n&bitmask)>>ith; or:
        if((bitmask&n)==0){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        System.out.println(getIth(5, 1));
        //5th = 101
        // 1st bit : 0
        
    }
}
