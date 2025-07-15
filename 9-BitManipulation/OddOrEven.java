import java.util.Scanner;

public class OddOrEven {

    public static void oddOrEven(int n){
        int bitmask = 1;
        if((n & bitmask)== 0){
            System.out.println("even");
            return;
        }else{
            System.out.println("odd");
            return;
        }
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        oddOrEven(n);
        sc.close();


        // 000 0   all evens have 0th bit(LSB) as 0 and, all odds have 0th (MSB) as 1
        // 001 1
        // 010 2
        // 011 3
        // 100 4
        // 101 5
        // 110 6
        // 111 7
        
    }
}