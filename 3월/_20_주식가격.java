class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length - 1;i++){
            int index = 0;
            
            for(int j=i+1;j<prices.length;j++){
                index++;
                
                if(prices[j] < prices[i]){
                    break;
                }
            }
            
            answer[i] = index;
        }
        
        return answer;
    }
}