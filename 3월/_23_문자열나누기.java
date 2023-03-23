import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int count1 = 0;
        int count2 = 0;
        
        char c = '0';
        
        for(int i=0;i<s.length();i++){
            if(count1 ==0 && count2 == 0){
                c = s.charAt(i);
                count1++;
            } else {
                if(c == s.charAt(i)){
                    count1++;
                }else{
                    count2++;
                }
            }
            
            if(count1 == count2){
                answer++;
                count1 = count2 = 0;
            }
        }
        
        if((count1 != 0) || (count2 != 0)){
            answer++;
        }
        
        return answer;
    }
}