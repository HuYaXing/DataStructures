package leetcode竞赛.九月.sf9_16;

import leetcode竞赛.九月.滑动;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/18 下午3:18
 */
public class Main {

    public static void main(String[] args) {
        int[][] init_state = new int[][]{
                {2, 8, 3},
                {1, 0, 4},
                {7, 6, 5}
        };
        int[][] final_state = new int[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };
        Main main = new Main();
        System.out.println(main.minMoveStep(init_state, final_state));
    }

    public int x[] = {1, 0, -1, 0};
    public int y[] = {0, 1, 0, -1};
    int[][] a = new int[3][3];
    public Map<Board, Board> map = new HashMap<>();

    public int minMoveStep(int[][] init_state, int[][] final_state) {
        a = final_state;
        Queue<Board> queue = new ArrayDeque<>();
        queue.add(new Board());
        bfs(queue, map);
        Board board1;
        if ((board1 = (Board) map.get(new Board(init_state))) != null) {
            return board1.count;
        } else {
            return -1;
        }
    }

    public void bfs(Queue<Board> queue, Map<Board, Board> map) {
        while (!queue.isEmpty()) {
            Board board = queue.poll();
            for (int i = 0; i < 4; i++) {
                Board temp = new Board(board, a);
                temp.move(i);
                if (!map.containsKey(temp)) {
                    map.put(temp, temp);
                    queue.add(temp);
                }
            }
        }
    }

    class Board {
        public int[][] board = new int[3][3];
        public int i = 1, j = 2;
        public int count = 0;

        public Board() {
        }

        public Board(int[][] board) {
            this.board = board;
        }

        public Board(Board board, int[][] final_state) {
            this.board = final_state;
            this.i = board.i;
            this.j = board.j;
            for (int i = 0; i < this.board.length; i++) {
                for (int j = 0; j < this.board[0].length; j++) {
                    this.board[i][j] = board.board[i][j];
                }
            }
            this.count = board.count;
        }

        public void move(int i) {
            if (check(this.i + x[i], this.j + y[i])) {
                this.board[this.i][this.j] = this.board[this.i + x[i]][this.j + y[i]];
                this.i += x[i];
                this.j += y[i];
                this.board[this.i][this.j] = 0;
                this.count++;
            }
        }

        public boolean check(int x, int y) {
            return x >= 0 && x <= 1 && y >= 0 && y <= 2;
        }

        @Override
        public int hashCode() {
            return this.board[0][0];
        }

        @Override
        public boolean equals(Object object) {
            Board temp = (Board) object;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != temp.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
