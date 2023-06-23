class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int oriNum = x;
        
        int sum = 0;
        
        for(int i = 10000; i > 0; i /= 10){
            sum += x / i;
            x %= i;
        }
        
        if(sum == 0){
            return false;
        }
    
        return (oriNum % sum == 0);
    }
}