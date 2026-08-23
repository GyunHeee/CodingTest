import java.util.*;

class Solution {

    boolean[] visited;
    ArrayList<Integer>[] graph;

    public int solution(int n, int[][] wires) {

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = n;

        for (int[] wire : wires) {

            int a = wire[0];
            int b = wire[1];

            // 1. 전선 실제로 끊기
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));

            // 2. a쪽에 몇 개 있는지 DFS
            visited = new boolean[n + 1];
            int countA = dfs(a);

            // 3. 나머지는 b쪽
            int countB = n - countA;

            // 4. 차이 계산
            int diff = Math.abs(countA - countB);
            answer = Math.min(answer, diff);

            // 5. 끊었던 전선 다시 연결
            graph[a].add(b);
            graph[b].add(a);
        }

        return answer;
    }

    int dfs(int current) {

        visited[current] = true;

        int count = 1;

        for (int next : graph[current]) {

            if (visited[next]) {
                continue;
            }
            count += dfs(next);
        }

        return count;
    }
}
