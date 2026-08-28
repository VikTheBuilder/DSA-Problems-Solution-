//Brute-
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 1, j=1;
        while(k>0){
            if(search(arr, i) == -1) k--;
            i++;
        }
        return i-1;
    }
    public int search(int[] nums, int target) {
        int n= nums.length;
        int low=0; 
        int high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid-1;
        }
        return -1;
    }
}

//Optimal--
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n= arr.length;
        int low=0; 
        int high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) low = mid + 1;
            else high = mid-1;
        }
        return low+k;
    }
}
