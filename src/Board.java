/**
 * Created by Alexey Kutepov on 22.02.15.
 */
public class Board {
    private final int[][] board;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.board = blocks;
    }

    // board dimension N
    public int dimension() {
        return board.length;
    }

    // number of blocks out of place
    public int hamming() {
        int hamming = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    int position = getPosition(i, j);
                    if (position != board[i][j]) {
                        hamming++;
                    }
                }
            }
        }
        return hamming;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int position = getPosition(i, j);
                if (board[i][j] == 0 && position != (board.length*board.length)) {
                    return false;
                } else  if (position != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // a boadr that is obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        return null;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        return null;
    }

    // unit tests (not graded)
    public static void main(String[] args) {

    }

    private int getPosition(int i, int j) {
        return i * board.length + j + 1;
    }
}
