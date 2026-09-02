import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer[]> map = new HashMap<>();
        HashMap<String, Integer[]> map2 = new HashMap<>();
        // 장르별 총재생 수
        HashMap<String, Integer> totalMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];

            set.add(genre);

            totalMap.put(
                genre,
                totalMap.getOrDefault(genre, 0) + plays[i]
            );
            
            // 해당 장르의 첫 번째 곡
            if (!map.containsKey(genre)) {
                map.put(genre, new Integer[]{plays[i], i});
                continue;
            }

            // 현재 곡이 기존 1등보다 재생 수가 많음
            if (plays[i] > map.get(genre)[0]) {
                // 기존 1등을 2등으로 옮김
                map2.put(genre, map.get(genre));

                // 현재 곡을 1등으로 저장
                map.put(genre, new Integer[]{plays[i], i});
            } else {
                // 아직 2등이 없다면 현재 곡을 2등으로 저장
                if (!map2.containsKey(genre)) {
                    map2.put(genre, new Integer[]{plays[i], i});
                }
                // 기존 2등보다 재생 수가 많으면 교체
                else if (plays[i] > map2.get(genre)[0]) {
                    map2.put(genre, new Integer[]{plays[i], i});
                }
            }
        }
        
        
        List<String> genreList = new ArrayList<>(set);

        genreList.sort((a, b) ->
            Integer.compare(totalMap.get(b), totalMap.get(a))
        );

        List<Integer> result = new ArrayList<>();

        for (String genre : genreList) {
            result.add(map.get(genre)[1]);

            if (map2.containsKey(genre)) {
                result.add(map2.get(genre)[1]);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}