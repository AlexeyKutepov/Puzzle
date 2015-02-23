import java.util.*;

/**
 * Created by Alexey Kutepov on 22.02.15.
 */
public class Solver {
    private Node node;
    private int moves = 0;
    private  boolean solvable = false;

    private class Node {
        private final Board board;
        private final Node parent;

        public Node(Board board, Node parent) {
            this.board = board;
            this.parent = parent;
        }

        public Board getBoard() {
            return board;
        }

        public Node getParent() {
            return parent;
        }
    }

    private static Comparator<Node> comparator = new Comparator<Node>() {

        @Override
        public int compare(Node node1, Node node2) {
            return node1.getBoard().manhattan() - node2.getBoard().manhattan();
        }
    };

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        boolean solvableTwin = false;
        if (initial == null) {
            throw new NullPointerException();
        }

        Node node = new Node(initial, null);
        Node nodeTwin = new Node(initial.twin(), null);

        while (!solvable && !solvableTwin) {
            if (node.getBoard().isGoal()) {
                solvable = true;
                break;
            } else if (nodeTwin.getBoard().isGoal()) {
                solvableTwin = true;
                break;
            }
            MinPQ<Node> minPQ = new MinPQ<Node>(comparator);


            Stack boardStack = (Stack) node.getBoard().neighbors();
            for (Object item : boardStack) {
                minPQ.insert(new Node((Board)item, node));
            }
            Node minNode = minPQ.delMin();
            if (minNode.getBoard().equals(node.getBoard())) {
                minNode = minPQ.delMin();
            }
            node = minNode;
            moves++;


            MinPQ<Node> minPQTwin = new MinPQ<Node>(comparator);
            Stack boardStackTwin = (Stack) nodeTwin.getBoard().neighbors();
            for (Object item : boardStackTwin) {
                minPQTwin.insert(new Node((Board)item, node));
            }
            Node minNodeTwin = minPQTwin.delMin();
            if (minNodeTwin.getBoard().equals(nodeTwin.getBoard())) {
                minNodeTwin = minPQTwin.delMin();
            }
            nodeTwin = minNodeTwin;
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!solvable) {
            return -1;
        }
        return moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!solvable) {
            return null;
        }
        Stack<Board> stack = new Stack<Board>();
        Node iterNode = node;
        while (iterNode != null) {
            stack.push(iterNode.getBoard());
            iterNode = iterNode.getParent();
        }
        return stack;
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
