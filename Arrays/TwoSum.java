/* Problem - 1. Two Sum
https://leetcode.com/problems/two-sum/
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        // Array and target is given, find sum of 2 indices to achieve target
        int[] arr = {2,4,1,7,0,2};
        int target = 7;
        int[] bruteResult = new int[2];
        int[] optimalResult = new int[2];
        //Solution Brute force
        for(int i = 0; i<arr.length-1;i++){
            for(int j = i+1; j<arr.length;j++){
                if(target == arr[i]+arr[j]){
                    bruteResult[0]=i;
                    bruteResult[1]=j;
                    break;
                }
            }
        }
        System.out.println("Brute force solution Indices = "+bruteResult[0]+" & "+bruteResult[1]);

        //Optimal Solution - One-Pass Hashmap Lookup
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                optimalResult[0]=map.get(target-arr[i]);
                optimalResult[1]=i;
                break;
            }else{
                map.put(arr[i],i);
            }
        }
        System.out.println("Optimal solution Indices = "+optimalResult[0]+" & " +
                optimalResult[1]);
    }
}

/* Solution Explanation:
    1. Brute Force - 2 pointer iterative
        - Start with 1 pointer 'i' and iterate another pointer 'j' over the array
        - and if sum is equal to target then return indices
        - O(n^2) Time and O(1) Space Complexity
    2. Optimal - One-Pass hashmap lookup
        - Starts to check Target - Current number is in map or not
        - if not then add into map
        - when 2nd index try to perform target - current number it will be able to find another index in map.
        - O(n) Time and O(n) Space Complexity
 */