//Brute Force--
class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> s = new HashSet<>();
        int c=0;
        for(int i=0; i<digits.length; i++){
            for(int j=0; j<digits.length; j++){
                for(int k=0; k<digits.length; k++){
                    if(digits[i]==0) continue;
                    if(digits[k] % 2 != 0) continue;
                    if(i!= j && k!= j && i!= k){
                        int d = digits[i]*100+ digits[j]*10 + digits[k];
                        if(!s.contains(d) && d%2==0){
                            s.add(d);
                            c++;
                        }
                    }
                }
            }
        }
        return c;
    }
}
