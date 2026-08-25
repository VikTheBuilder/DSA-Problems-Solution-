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

//solution 2
class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int cur = k;
        while (seen.contains(cur)) {
            cur += k;
        }
        return cur;
    }
}
