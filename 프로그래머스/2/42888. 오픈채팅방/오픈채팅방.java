import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for (int i=0; i<record.length; i++) {
            if (record[i].split(" ")[0].equals("Enter")) {
                answer.add(record[i].split(" ")[1] + 
" " + record[i].split(" ")[2] + "님이 들어왔습니다.");
                map.put(record[i].split(" ")[1], record[i].split(" ")[2]);
            }
            
            if (record[i].split(" ")[0].equals("Leave")) {
                answer.add(record[i].split(" ")[1] + " " + map.get(record[i].split(" ")[1]) + "님이 나갔습니다.");
            }
            
            if (record[i].split(" ")[0].equals("Change")) {
                map.put(record[i].split(" ")[1], record[i].split(" ")[2]);
            }
        }
        
        for (int i=0; i<answer.size(); i++) {
            String uid = answer.get(i).split(" ")[0];
            
            if (!map.get(uid).isEmpty()) {
                answer.set(
                    i,
                    map.get(uid) + "님이 " + answer.get(i).split(" ")[2]
                );
            } else {
                answer.set(i, answer.get(i).split(" ")[1] + answer.get(i).split(" ")[2]);
            }
        }
        
        
        return answer;
    }
}