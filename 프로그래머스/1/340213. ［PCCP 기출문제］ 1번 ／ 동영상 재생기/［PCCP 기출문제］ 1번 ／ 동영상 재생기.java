import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int pos_sec = toSecond(pos.split(":")[0], pos.split(":")[1]);
        int video_len_sec = toSecond(video_len.split(":")[0], video_len.split(":")[1]);
        int op_start_sec = toSecond(op_start.split(":")[0], op_start.split(":")[1]);
        int op_end_sec = toSecond(op_end.split(":")[0], op_end.split(":")[1]);
        
        if (checkOpening(pos_sec, op_start_sec, op_end_sec)) {
            pos_sec = op_end_sec;
        }
        
        for (String command : commands) {
            if (command.equals("next")) {
                pos_sec += 10;
                
                if (pos_sec > video_len_sec) {
                    pos_sec = video_len_sec;
                }
                
                if (checkOpening(pos_sec, op_start_sec, op_end_sec)) {
                    pos_sec = op_end_sec;
                }
            } else if (command.equals("prev")) {
                pos_sec -= 10; 
                
                if (pos_sec < 0) {
                    pos_sec = 0;
                }
                
                if (checkOpening(pos_sec, op_start_sec, op_end_sec)) {
                    pos_sec = op_end_sec;
                }
            }
        }
        
        int min = pos_sec / 60;
        int sec = pos_sec % 60;
        
        return String.format("%02d:%02d", min, sec);
    }

    boolean checkOpening(int pos, int start, int end) {
        if (pos >= start && pos <= end) {
            return true;
        }
        
        return false;
    }
    
    int toSecond(String minStr, String secStr) {
        Integer min = Integer.valueOf(minStr);
        Integer sec = Integer.valueOf(secStr);
        
        return min * 60 + sec;
    }
}