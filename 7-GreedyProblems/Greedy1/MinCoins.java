package Greedy1;
import java.util.Arrays;
public class MinCoins {
    public static int minCoins(int[] coins, int money){
        Arrays.sort(coins);
        int count = 0;
        for(int i = coins.length-1; i>=0; i--){
            if(money>=coins[i]){
                count += money/coins[i];
                money = money%coins[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5,10,20,50,100,500,2000};
        int money = 121;
        money = 590;
        System.out.println(minCoins(coins, money));

        
    }
}
