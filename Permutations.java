class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }
    void recurPermute(int i, int[] nums, List<List<Integer>> ans){
        if(i == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int k=0; k<nums.length; k++){
                ds.add(nums[k]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int j=i; j<nums.length; j++){
            swap(j, i, nums);
            recurPermute(i+1, nums, ans);
            swap(j, i, nums);
        }
    }
    void swap(int j, int i, int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return;
    }
}