import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<String> set = new HashSet<>();
    static String[] userList;
    static String[] banList;
    static String[] nowList;
    static Boolean[] userCheck;


    public int solution(String[] user_id, String[] banned_id) {
        userList = user_id;
        banList = banned_id;
        nowList = new String[banned_id.length];
        userCheck = new Boolean[userList.length];
        Arrays.fill(userCheck, false);

        getList(0);

        return set.size();
    }

    private void getList(int nowIndex) {
        if (nowIndex == nowList.length) {
            String[] answerList = new String[nowList.length];

            System.arraycopy(nowList, 0, answerList, 0, nowList.length);

            Arrays.sort(answerList);

            StringBuilder answer = new StringBuilder();

            for (String s : answerList) {
                answer.append(s);
            }

            set.add(String.valueOf(answer));
            return;
        }

        for (int i = 0; i < userList.length; i++) {
            if (userList[i].length() == banList[nowIndex].length()) {
                if (checkAble(userList[i], banList[nowIndex])) {
                    if (userCheck[i]) {
                        continue;
                    }

                    userCheck[i] = true;
                    nowList[nowIndex] = userList[i];
                    getList(nowIndex + 1);
                    userCheck[i] = false;
                }
            }
        }
    }

    private boolean checkAble(String user, String ban) {
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*') {
                if (ban.charAt(i) != user.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}