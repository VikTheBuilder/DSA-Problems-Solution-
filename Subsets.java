class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // int n = nums.length;
        // int NSubsets = 1<<n; //2^n
        // List<List<Integer>> ans = new ArrayList<>();
        // for(int i=0; i<NSubsets; i++){
        //     List<Integer> l = new ArrayList<>();
        //     for(int j=0; j<n; j++){
        //         if((int)(i&(1<<j))!=0) l.add(nums[j]);
        //     }
        //     ans.add(l);
        // } 
        // return ans;
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, current, ans);
        return ans;
         
    }
    void helper(int i, int[] nums, List<Integer> current, List<List<Integer>> ans){
        if(i>=nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        helper(i+1, nums, current, ans);
        current.remove(current.size() - 1);
        helper(i+1, nums, current, ans);
    }
}
