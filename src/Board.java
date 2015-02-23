import java.util.Stack;

/**
 * Created by Alexey Kutepov on 22.02.15.
 */
public class Board {
    private final int[][] board;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        board = new int[blocks.length][blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                board[i][j] = blocks[i][j];
            }
        }
    }

    // board dimension N
    public int dimension() {
        return board.length;
    }

    // number of blocks out of place
    public int hamming() {
        int hamming = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
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
        int sum = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (board[i][j] != 0) {
                    sum += manhattan(i, j);
                }
            }
        }

        return sum;
    }

    private int manhattan(int i, int j) {
        return Math.abs(i - getRow(board[i][j])) + Math.abs(j + 1 - getCol(board[i][j]));
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                int position = getPosition(i, j);
                if (board[i][j] == 0 && position != (dimension()*dimension())) {
                    return false;
                } else  if (board[i][j] != 0 && position != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // a boadr that is obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        int[][] newBoard = new int[dimension()][dimension()];
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        int rowSwap = 0;
        if (newBoard[0][0] == 0 || newBoard[0][1] == 0) {
            rowSwap = 1;
        }

        int temp = newBoard[rowSwap][0];
        newBoard[rowSwap][0] = newBoard[rowSwap][1];
        newBoard[rowSwap][1] = temp;
        return new Board(newBoard);
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        return (this.toString().equals(that.toString()));
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        int i0 = 0;
        int j0 = 0;
        Stack<Board> boardMinPQ = new Stack<Board>();
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (board[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                    break;
                }
            }
        }

        if (i0 > 0) {
            int[][] newBoard = copyArray();
            int buf = newBoard[i0 - 1][j0];
            newBoard[i0 - 1][j0] = newBoard[i0][j0];
            newBoard[i0][j0] = buf;
            boardMinPQ.push(new Board(newBoard));
        }

        if (i0 < dimension() - 1) {
            int[][] newBoard = copyArray();
            int buf = newBoard[i0 + 1][j0];
            newBoard[i0 + 1][j0] = newBoard[i0][j0];
            newBoard[i0][j0] = buf;
            boardMinPQ.push(new Board(newBoard));
        }

        if (j0 > 0) {
            int[][] newBoard = copyArray();
            int buf = newBoard[i0][j0 - 1];
            newBoard[i0][j0 - 1] = newBoard[i0][j0];
            newBoard[i0][j0] = buf;
            boardMinPQ.push(new Board(newBoard));
        }

        if (j0 < dimension() - 1) {
            int[][] newBoard = copyArray();
            int buf = newBoard[i0][j0 + 1];
            newBoard[i0][j0 + 1] = newBoard[i0][j0];
            newBoard[i0][j0] = buf;
            boardMinPQ.push(new Board(newBoard));
        }

        return boardMinPQ;
    }

    private int[][] copyArray() {
        int[][] newBoard = new int[dimension()][dimension()];
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension() + "\n");
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                s.append(String.format("%2d ", board[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // unit tests (not graded)
    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        Board myBoard = new Board(test);
        System.out.print(myBoard.isGoal());
    }

    private int getPosition(int i, int j) {
        return i * dimension() + j + 1;
    }

    private int getRow(int position) {
        if (position % dimension() == 0) {
            return position / dimension() - 1;
        } else {
            return position / dimension();
        }
    }

    private int getCol(int position) {
        if (position % board.length == 0) {
            return board.length;
        } else {
            return position % board.length;
        }
    }
}
