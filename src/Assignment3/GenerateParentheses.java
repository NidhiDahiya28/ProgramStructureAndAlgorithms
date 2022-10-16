package Assignment3;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
    int k = 3;

    var res = GenerateParentheses.generateParenthesis(k);
    System.out.println(res);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n,0,0,"",result) ;
        return result;
    }

    public static void helper(int n , int open , int close , String sb , List<String> result){
        if(sb.length()==2*n){
            result.add(sb);
            return;
        }
        if(open<n){
            helper(n,open+1,close,sb+"(",result);
        }
        if(close<open){
            helper(n,open,close+1,sb+")",result);
        }
    }

}

