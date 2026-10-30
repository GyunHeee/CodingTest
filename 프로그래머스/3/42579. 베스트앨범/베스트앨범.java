import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer[]> map1 = new HashMap<>();
        HashMap<String, Integer[]> map2 = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            if (map.containsKey(genres[i])) {
                int cnt = map.get(genres[i]);
                map.put(genres[i], cnt + plays[i]);
                
                if (plays[i] > map1.get(genres[i])[1]) {
                    map2.put(genres[i], map1.get(genres[i]));
                    map1.put(genres[i], new Integer[]{i, plays[i]});
                } else {
                    if (map2.containsKey(genres[i]) && plays[i] > map2.get(genres[i])[1]) {
                        map2.put(genres[i], new Integer[]{i, plays[i]});
                    }
                    
                    if (!map2.containsKey(genres[i])) {
                        map2.put(genres[i], new Integer[]{i, plays[i]});
                    }
                }
            } else {
                map.put(genres[i], plays[i]);
                set.add(genres[i]);
                map1.put(genres[i], new Integer[]{i, plays[i]});
            }
        }
        
        List<String> genreList = new ArrayList<>(set);
        genreList.sort((a, b) ->
            Integer.compare(map.get(b), map.get(a))
        );
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<genreList.size(); i++) {
            String genre = genreList.get(i);
            int index1 = map1.get(genre)[0];
            answer.add(index1);
            
            if (map2.containsKey(genreList.get(i))) {
                int index2 = map2.get(genre)[0];   
                answer.add(index2);
            }
        }
        
        
        return answer;
    }
}