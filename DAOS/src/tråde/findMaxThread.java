package tråde;

public class findMaxThread implements Runnable {
    private int[][] board;
    private int max;

    public findMaxThread(int[][] board) {
        this.board = board;
        this.max = Integer.MIN_VALUE;
    }

    @Override
    public void run() {

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[j].length; i++) {
                if (board[j][i] > max) {
                    max = board[j][i];
                }
            }
        }
    }

    public int getMax() {
        return max;
    }
}
