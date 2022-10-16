package Assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberCombination {
    public static void main(String[] args) {
    String digit = "23";

    var res = PhoneNumberCombination.letterCombinations(digit);
    System.out.println(res);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.equals(""))
            return ans;

        HashMap<Character,String> hm=new HashMap<>();
        fillHashMap(hm);
        recur(digits,hm,ans,0,new StringBuffer(""));

        return ans;
    }

    private static void fillHashMap(HashMap<Character,String> hm){
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
    }

    private static void recur(String digits,HashMap<Character,String> hm,List<String> ans,int i,StringBuffer sb){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String str=hm.get(digits.charAt(i));
        for(int j=0;j<str.length();j++){
            sb.append(str.charAt(j));
            recur(digits,hm,ans,i+1,sb);
            sb.setLength(sb.length() - 1);
        }
    }
}


