package 玩转算法面试.递归与回溯.二维平面;

/**
 * @Author HYStar
 * @Date 2020/4/29 19:32
 */
public class 单词搜索 {

    public static void main(String[] args) {

    }

    //代表四个方向移动
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int m, n;

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从board[startX][startY]开始寻找word[index...word.length]
     *
     * @param board
     * @param word
     * @param index
     * @param startX
     * @param startY
     * @return
     */
    private boolean searchWord(char[][] board, String word, int index,
                               int startX, int startY) {
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            //尝试向其他四个方向查找
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            //回溯
            visited[startX][startY] = false;
        }
        return false;
    }


}
