public class GetSubSets {

    // important note: here choice is given to each letter that if they want to enter the string
    public static void getSubstring(String s, int ind, String ans){
        if(ind == s.length()){
            if(ans == ""){
                System.out.println("null");
                return;
            }
            System.out.println(ans);
            return;
        }
        getSubstring(s, ind+1, ans+s.charAt(ind));
        getSubstring(s, ind+1, ans);
    }
    public static void main(String[] args) {
        String s = "abc";
        getSubstring(s, 0, "");
        
    }
}
