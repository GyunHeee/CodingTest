import java.util.*;

class Solution {
    public int solution(String[] board) {
        int height = board.length;
        int width = board[0].length();

        int[][] distance = new int[height][width];

        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (board[x].charAt(y) == 'R') {
                    queue.offer(new int[]{x, y});
                    distance[x][y] = 0;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentX = current[0];
            int currentY = current[1];

            for (int direction = 0; direction < 4; direction++) {
                int nextX = currentX;
                int nextY = currentY;

                while (true) {
                    int movedX = nextX + dx[direction];
                    int movedY = nextY + dy[direction];

                    if (movedX < 0 || movedX >= height ||
                        movedY < 0 || movedY >= width) {
                        break;
                    }

                    if (board[movedX].charAt(movedY) == 'D') {
                        break;
                    }

                    nextX = movedX;
                    nextY = movedY;
                }

                if (distance[nextX][nextY] != -1) {
                    continue;
                }

                distance[nextX][nextY] =
                        distance[currentX][currentY] + 1;

                if (board[nextX].charAt(nextY) == 'G') {
                    return distance[nextX][nextY];
                }

                queue.offer(new int[]{nextX, nextY});
            }
        }

        return -1;
    }
}