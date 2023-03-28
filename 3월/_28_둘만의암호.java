class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);

            for (int j = 0; j < index; j++) {
                if (alphabet == 'z') {
                    alphabet = 'a';
                } else {
                    alphabet++;
                }

                for (int k = 0; k < skip.length(); k++) {
                    char skipAlphabet = skip.charAt(k);

                    if (skipAlphabet == alphabet) {
                        j--;
                        break;
                    }
                }
            }

            answer.append(alphabet);
        }

        return answer.toString();
    }
}