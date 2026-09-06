class Solution {
    public void nextPermutation(int[] nums) {
        int ind =-1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if (ind == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]>nums[ind]){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
        }
        reverse(nums, ind + 1, nums.length - 1);
    }
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}