public class IsPowerOf2 {
    public static boolean ispowerOf2(int n){
        if ((n & n-1)==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(ispowerOf2(16)); //true
        System.out.println(ispowerOf2(14)); //false
        System.out.println(ispowerOf2(21)); //false
        System.out.println(ispowerOf2(32)); // true
    }
}
