class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int n1 = 1;
        int n2 = 2;
        int temp = 0;
        for(int i = n; i>2; i--){
            temp = n2;
            n2 = n2+n1;
            n1 = temp;
        }
        return n2;
    } 
}
