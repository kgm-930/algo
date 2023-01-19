class Solution {
    public String solution(String s) {
        char preWord = s.charAt(0);

        if (preWord >= 'a' && preWord <= 'z') {
            preWord += 'A' - 'a';
        }

        StringBuilder answer = new StringBuilder(preWord + "");

        for (int i = 1; i < s.length(); i++) {
            char nowWord = s.charAt(i);

            if (nowWord == ' ') {
            } else if (preWord == ' ') {
                if (nowWord >= 'a' && nowWord <= 'z') {
                    nowWord += 'A' - 'a';
                }
            } else if (nowWord >= 'A' && nowWord <= 'Z') {
                nowWord -= 'A' - 'a';
            }

            preWord = nowWord;
            answer.append(nowWord);
        }

        return answer.toString();
    }
}