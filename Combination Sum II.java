class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, current, candidates, target, ans);
        return ans;
    }
    void findCombination(int ind, List<Integer> current,int[] nums, int target, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = ind; i<nums.length; i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            current.add(nums[i]);
            findCombination(i+1, current, nums, target-nums[i], ans);
            current.remove(current.size()-1);
        }
    }
}

