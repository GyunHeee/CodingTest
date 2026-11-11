import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vLen = toSeconds(video_len);
        int cur = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        cur = checkOpening(cur, opStart, opEnd);

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur -= 10;
                if (cur < 0) cur = 0; 
            } else if (cmd.equals("next")) {
                cur += 10;
                if (cur > vLen) cur = vLen; 
            }
            
            cur = checkOpening(cur, opStart, opEnd);
        }

        int min = cur / 60;
        int sec = cur % 60;

        return String.format("%02d:%02d", min, sec);
    }

    private int toSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private int checkOpening(int cur, int opStart, int opEnd) {
        if (cur >= opStart && cur <= opEnd) {
            return opEnd;
        }
        return cur;
    }
}