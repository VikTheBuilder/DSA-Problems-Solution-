class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, current, candidates, target, ans);
        return ans;
    }
    void findCombinations(int i, List<Integer> current, int[] nums, int target, List<List<Integer>> ans){
        if(i == nums.length){
            if(target == 0) ans.add(new ArrayList<>(current));
            return;
        }
        if(nums[i] <= target){
            current.add(nums[i]);
            findCombinations(i, current, nums, target-nums[i], ans);
            current.remove(current.size()-1);
        }
        findCombinations(i+1, current, nums, target, ans);
    }
}
