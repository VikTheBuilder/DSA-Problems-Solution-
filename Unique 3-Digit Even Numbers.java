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
//Optimized Solution--
class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<digits.length; i++){
            if(digits[i] == 0) continue;
            for(int j=0; j<digits.length; j++){
                if(j == i) continue;
                for(int k=0; k<digits.length; k++){
                    if(k == i || k == j) continue;
                    if(digits[k] % 2 == 0){
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        s.add(num);
                    }
                }
            }
        }
        return s.size();
    }
}
//Optimal--
class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int d : digits){
            freq[d]++;
        }
        int ans = 0;
        for(int i = 1; i <= 9; i++){
            if(freq[i] == 0) continue;
            freq[i]--;
            for(int j = 0; j <= 9; j++){
                if(freq[j] == 0) continue;
                freq[j]--;
                for(int k = 0; k <= 8; k += 2){
                    if(freq[k] > 0){
                        ans++;
                    }
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return ans;
    }
}
