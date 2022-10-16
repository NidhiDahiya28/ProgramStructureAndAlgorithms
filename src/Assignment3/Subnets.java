package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subnets {
    public static void main(String[] args) {
    int[] nums = {1,2,3};

    var result = Subnets.subsets(nums);
    System.out.println(result);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subset(result,0,nums,new ArrayList<>());
        return result;
    }

    private static void subset(List<List<Integer>> result, int current , int[] nums, ArrayList<Integer> temp ){
        result.add(new ArrayList<>(temp));
        for(int i = current ;i < nums.length;i++){
            temp.add(nums[i]);
            subset(result,i+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}


