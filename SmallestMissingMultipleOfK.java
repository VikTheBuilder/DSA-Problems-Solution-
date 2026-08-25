//Solution 1
class Solution {
    public int missingMultiple(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        int n=1;
        while(true){
            if(!list.contains(k*n)){
                return k*n;
            }
            n++;
        }
    }
}

