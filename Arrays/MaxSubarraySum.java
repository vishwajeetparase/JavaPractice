/* Problem - 53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/
*/

public class MaxSubarraySum {
    static void main(String[] args) {
        // Given Array
        int[] arr = { 2, -4, 2, 6, -8, -9};

        // Solution 1 - Brute force
        int maxSum=arr[0];
        for(int i=0;i<arr.length;i++){
            int tempMaxSum = 0;
            for(int j=i;j<arr.length;j++){
                tempMaxSum+=arr[j];
                if(tempMaxSum>maxSum){
                    maxSum=tempMaxSum;
                }
            }
        }
        System.out.println("Brute Force MaxSum - "+maxSum);

        // Optimal solution - Kadane's Algorithm
        int result = arr[0];
        int tempSum = 0;
        for(int i=0;i<arr.length;i++) {
            tempSum += arr[i];
            if (tempSum > result) {
                result = tempSum;
            }
            if(tempSum<0){
                tempSum = 0;
            }
        }
        System.out.println("Optimal MaxSum - "+result);
    }
}
/* Solution Explanation:
Logic:
    It iterates through the array once.
    At each element, it makes a key decision:
        extend the current subarray (by adding the element) or start a new subarray (if the previous subarray's sum had become negative).
Efficiency:
    It finds the maximum sum in a single pass (O(n) time) using only two variables (O(1) space).
 */