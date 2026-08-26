class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = s.length();
        int i = 0, j = 0;
        int c = 0;
        int min = l + 1;
        String result = "";
        while(j<l){
            if (s.charAt(j) == '1')
                c++;
            j++;
            while(c>=k){
                if(c==k){
                    if(min>(j-i)){
                        min = j-i;
                        result = s.substring(i, j);
                    }
                    else if (j-i == min) {
                        String cand = s.substring(i, j);
                        if (cand.compareTo(result) < 0) {
                        result = cand;
                        }
                    }
                }
                if (s.charAt(i) == '1')
                    c--;
                i++;
            }
        }
        return result;
    }
}
