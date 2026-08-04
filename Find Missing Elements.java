// Brute Force
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result= new ArrayList<>();
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            max=Math.max(max, nums[i]);
            min=Math.min(min, nums[i]);
        }
        for(int j= min; j<max; j++){
        if(!contains(nums, j)){
                result.add(j); 
            }
        }
        return result;
    }
    boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}

// HashSet 
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
