class Solution {
    public int smallestNumber(int n, int t) {
        int a=n;
        while(proDigits(a)%t!=0){
            a++;
        }
        return a;
    }
    int proDigits(int num){
        int p=1;
        while(num>0){
            p *= num%10;
            num /=10;
        }
        return p;
    }
}
