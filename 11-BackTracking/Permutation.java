public class Permutation {
    // note: here choice is not given to each letter rather the choice is given to each place, that it has three option to keep, and it can keep one. 

    public static void allPermutations(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i<s.length(); i++){
            String str = s.substring(0, i) + s.substring(i+1, s.length());
            allPermutations(str, ans+s.charAt(i));
        }
    }
    public static void main(String[] args) {
        String s = "abc";
        allPermutations(s, "");

        
    }
}
