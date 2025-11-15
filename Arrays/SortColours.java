/* Problem - 75. Sort Colors
https://leetcode.com/problems/sort-colors/
 */

import java.util.Arrays;

public class SortColours {
    public static void main(String[] args) {
        // unsorted array of 0s, 1s and 2s are given sort in order
        // multiple copied for multiple approaches
        int[] arr0 = {2,1,0,0,2,2};
        int[] arr1 = {2,1,0,0,2,2};
        int[] arr2 = {2,1,0,0,2,2};

        // Brute Force - General sort
        Arrays.sort(arr0);
        System.out.println("Brute Force solution = "+Arrays.toString(arr0));

        //Optimal solution 1 - Counting sort
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i : arr1){
            if(i==0){
                zero++;
            }else if(i==1){
                one++;
            }else{
                two++;
            }
        }
        for(int i=0;i<arr1.length;i++){
            if(zero>0){
                arr1[i]=0;
                zero--;
            }else if(one>0){
                arr1[i]=1;
                one--;
            }else{
                arr1[i]=2;
                two--;
            }
        }
        System.out.println("Optimal solution 1 = "+Arrays.toString(arr1));

        // Optimal 2 - Dutch National Flag algorithm
        int start=0;
        int mid=0;
        int end=arr2.length-1;

        while(mid<=end){
            if(arr2[mid]==0){
                swapArray(arr2,start,mid);
                start++;
                mid++;
            }else if(arr2[mid]==1){
                mid++;
            }else{
                swapArray(arr2,mid,end);
                end--;
            }
        }
        System.out.println("Optimal solution 1 = "+Arrays.toString(arr2));
    }

    private static void swapArray(int[] arr, int pos1, int pos2) {
        int temp=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;
    }
}

/*
Solution Explanation:
    1. Brute Force - General Sort
        - This solution uses the built-in Arrays.sort() method from Java.
        - It's a general-purpose sorting algorithm that doesn't use the fact that the array only contains 0s, 1s, and 2s.
        - Time Complexity: O(n log n)
        - Space Complexity: O(log n) to O(n) (depending on the internal sort implementation)
    2. Optimal 1 - Counting Sort
        - This is a two-pass approach.
            Pass 1: Iterate through the array once to count the total number of 0s, 1s, and 2s.
            Pass 2: Overwrite the original array by first placing all the counted 0s, then all the 1s, and finally all the 2s.
        - Time Complexity: O(n) (for the two passes, O(n + n) = O(2n), which simplifies to O(n))
        - Space Complexity: O(1) (only three counter variables are used)
    3. Optimal 2 - Dutch National Flag Algorithm
        - This is the most efficient one-pass solution using constant space.
        - It uses three pointers:
            start (points to the last known 0),
            mid (points to the current element being processed),
            and end (points to the first known 2).
        - The mid-pointer iterates from the beginning to the end.
        - If arr[mid] is 0, swap it with arr[start] and increment both start and mid.
        - If arr[mid] is 1, it's in the correct place, so just increment mid.
        - If arr[mid] is 2, swap it with arr[end] and decrement end (do not increment mid, as the new element at mid needs to be processed).
        - Time Complexity: O(n) (a single pass through the array)
        - Space Complexity: O(1) (only three pointer variables are used)
 */