import java.util.Comparator;

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
        private int nodeMoves;

        public Node(Board inBoard, Node inParent, int inMoves) {
            this.board = inBoard;
            this.parent = inParent;
            this.nodeMoves = inMoves;
        }

        public Board getBoard() {
            return board;
        }

        public Node getParent() {
            return parent;
        }

        public int getNodeMoves() {
            return nodeMoves;
        }
    }

    private Comparator<Node> comparator = new Comparator<Node>() {

        @Override
        public int compare(Node node1, Node node2) {
            return (node1.getBoard().manhattan() + node1.getNodeMoves()) - (node2.getBoard().manhattan() + node2.getNodeMoves());
        }
    };

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new NullPointerException();
        }

        node = new Node(initial, null, 0);

        Node nodeTwin = new Node(initial.twin(), null, 0);

        MinPQ<Node> minPQ = new MinPQ<Node>(comparator);
        MinPQ<Node> minPQTwin = new MinPQ<Node>(comparator);

        if (node.getBoard().isGoal()) {
          solvable = true;
        }

        while (!node.getBoard().isGoal() && !nodeTwin.getBoard().isGoal()) {

//            System.out.println(node.getBoard().toString());
            Iterable<Board> boardStack = node.getBoard().neighbors();
            for (Board item : boardStack) {
              if (node.getParent() != null) {
                if (!item.equals(node.getParent().getBoard())) {
                  minPQ.insert(new Node(item, node, node.getNodeMoves() + 1));
                }
              } else {
                minPQ.insert(new Node(item, node, node.getNodeMoves() + 1));
              }
            }
            Node minNode = minPQ.delMin();

            if (minNode.getBoard().equals(node.getBoard())) {
                minNode = minPQ.delMin();
            }
//            else if (node.getParent() != null) {
//                if (minNode.getBoard().equals(node.getParent().getBoard())) {
//                    minNode = minPQ.delMin();
//                }
//            }
            node = minNode;

            if (node.getBoard().isGoal()) {
                solvable = true;
            }

            Iterable<Board> boardStackTwin = nodeTwin.getBoard().neighbors();
            for (Board item : boardStackTwin) {
              if (nodeTwin.getParent() != null) {
                if (!item.equals(nodeTwin.getParent().getBoard())) {
                  minPQTwin.insert(new Node(item, nodeTwin, nodeTwin.getNodeMoves() + 1));
                }
              } else {
                minPQTwin.insert(new Node(item, nodeTwin, nodeTwin.getNodeMoves() + 1));
              }
            }
            Node minNodeTwin = minPQTwin.delMin();
            if (minNodeTwin.getBoard().equals(nodeTwin.getBoard())) {
                minNodeTwin = minPQTwin.delMin();
            }
            /*else if (nodeTwin.getParent() != null) {
                if (minNodeTwin.getBoard().equals(nodeTwin.getParent().getBoard())) {
                    minNodeTwin = minPQTwin.delMin();
                }
            }*/
            nodeTwin = minNodeTwin;

            moves++;
        }
        moves = node.getNodeMoves();
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
