# Puzzle
Algorithms, Part I, Week 4

Submission
Submission time	Wed-25-Feb 06:18:22
Raw Score	72.59 / 100.00
Feedback	See the Assessment Guide for information on how to read this report.
Assessment Summary
Compilation:  PASSED
Style:        FAILED
Findbugs:     No potential bugs found.
API:          PASSED

Correctness:  26/27 tests passed
Memory:       8/8 tests passed
Timing:       0/17 tests passed

Aggregate score: 72.59% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]
Assessment Details
The following files were submitted:
----------------------------------
total 20K
-rw-r--r-- 1 6.0K Feb 25 14:20 Board.java
-rw-r--r-- 1 4.5K Feb 25 14:20 Solver.java
-rw-r--r-- 1 2.9K Feb 25 14:20 studentSubmission.zip


******************************************************************************
*  compiling
******************************************************************************


% javac Board.java
*-----------------------------------------------------------
================================================================

% javac Solver.java
*-----------------------------------------------------------
================================================================



% checkstyle *.java
*-----------------------------------------------------------
Solver.java:35:5: Static variable definition in wrong order.
================================================================


% findbugs *.class
*-----------------------------------------------------------
================================================================


Testing the APIs of your programs.
*-----------------------------------------------------------
Board:

Solver:

================================================================


******************************************************************************
*  correctness
******************************************************************************

Testing methods in Board
*-----------------------------------------------------------
Running 18 total tests.

Tests 6-9 and 17-18 rely upon toString() returning a board in the prescribed format.

Test 1: Test hamming() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle07.txt
  *  puzzle17.txt
  *  puzzle27.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 2: Test hamming() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 3: Test manhattan() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle07.txt
  *  puzzle17.txt
  *  puzzle27.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 4: Test manhattan() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 5: Test dimension() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
==> passed

Test 6: Test toString() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 7: Test neighbors() with file inputs to ensure that the correct neighbor board are generated
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 8: Test neighbors() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 9: Test twin() with file inputs to ensure that a correct twin is generated
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 10: Test twin() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 11: Test isGoal() on file inputs
  *  puzzle00.txt
  *  puzzle04.txt
  *  puzzle16.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-00.txt
  *  puzzle4x4-00.txt
==> passed

Test 12: Test isGoal() on N-by-N goal boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  6-by-6
  *  100-by-100
==> passed

Test 13: Check whether two Board objects can be created at the same time
  *   random boards of size 3-by-3 and 3-by-3
  *   random boards of size 4-by-4 and 4-by-4
  *   random boards of size 2-by-2 and 2-by-2
  *   random boards of size 3-by-3 and 4-by-4
  *   random boards of size 4-by-4 and 3-by-3
==> passed

Test 14: Check equals()
  *  reflexive
  *  symmetric
  *  checks that individual entries of array are equal
  *  argument is object of type String
  *  argument is object of type Object
  *  argument is null
  *  argument is Board of different dimension
==> passed

Test 15: Check that Board is immutable by changing argument array after construction
         and making sure Board does not change
==> passed

Test 16: Check that Board is immutable by testing whether methods
         return the same value, regardless of order in which called
  *  puzzle10.txt
  *  puzzle20.txt
  *  puzzle30.txt
  *  2-by-2
  *  3-by-3
  *  4-by-4
==> passed

Test 17: Call hamming() on a board that is kth-neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1th neighbor of puzzle27.txt
  * 2th neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed

Test 18: Call manhattan() on a board that is a kth-neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1th neighbor of puzzle27.txt
  * 2th neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed


Total: 18/18 tests passed!

================================================================

******************************************************************************
*  correctness (substituting reference Board.java)
******************************************************************************

Testing methods in Solver
*-----------------------------------------------------------
Running 9 total tests.

Test 1: Call moves() with file inputs to ensure that Solver solves the puzzle in the correct minimum number of moves
  *  puzzle00.txt
  *  puzzle01.txt
  *  puzzle02.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle05.txt
  *  puzzle06.txt
  *  puzzle07.txt
  *  puzzle08.txt
  *  puzzle09.txt
  *  puzzle10.txt
  *  puzzle11.txt
  *  puzzle12.txt
  *  puzzle13.txt
==> passed

Test 2: Call solution() with file inputs to ensure that the correct sequence of moves is followed
  *  puzzle00.txt
  *  puzzle01.txt
  *  puzzle02.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle05.txt
  *  puzzle06.txt
  *  puzzle07.txt
  *  puzzle08.txt
  *  puzzle10.txt
  *  puzzle15.txt
==> passed

Test 3: Create multiple Solver objects at the same time and still correctly function
  *  puzzle04.txt and puzzle04.txt
  *  puzzle00.txt and puzzle04.txt
  *  puzzle04.txt and puzzle00.txt
==> passed

Test 4: Call isSolvable() with file inputs
  *  puzzle01.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle17.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 5: Call isSolvable() on random 2-by-2 puzzles
  *  2-by-2
==> passed

Test 6: Call moves() on unsolvable puzzles
  *  puzzle2x2-unsolvable1.txt
  *  puzzle2x2-unsolvable2.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 7: Call solution() on unsolvable puzzles
  *  puzzle2x2-unsolvable1.txt
  *  puzzle2x2-unsolvable2.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 8: Check that Solver is immutable by comparing the results of two calls
        each to moves(), isSolvable(), and solution(). The results of these
        two consecutive calls must match.
==> passed

Test 9: Call moves() with file inputs
  *  puzzle14.txt
  *  puzzle15.txt
  *  puzzle16.txt
  *  puzzle17.txt
  *  puzzle18.txt
  *  puzzle19.txt
  *  puzzle20.txt
  *  puzzle21.txt
  *  puzzle22.txt
  *  puzzle23.txt
  *  puzzle24.txt
  *  puzzle25.txt
  *  puzzle26.txt
  *  puzzle27.txt
  *  puzzle28.txt
     java.lang.OutOfMemoryError: Java heap space
     Board.to2D(Board.java:108)
     Board.neighbors(Board.java:133)
     Solver.<init>(Solver.java:83)
     TestSolver.testMoves(TestSolver.java:47)
     TestSolver.test9(TestSolver.java:445)
     TestSolver.main(TestSolver.java:504)

  *  puzzle29.txt
  *  puzzle30.txt
     java.lang.OutOfMemoryError: Java heap space
     Board.<init>(Board.java:32)
     Board.neighbors(Board.java:141)
     Solver.<init>(Solver.java:83)
     TestSolver.testMoves(TestSolver.java:47)
     TestSolver.test9(TestSolver.java:447)
     TestSolver.main(TestSolver.java:504)

  *  puzzle31.txt
==> FAILED


Total: 8/9 tests passed!

================================================================

******************************************************************************
*  memory
******************************************************************************

Computing memory of Board
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of an N-by-N board

              N       student (bytes)    reference (bytes)
----------------------------------------------------------
=> passed     4           240                  248
=> passed     8           560                  568
=> passed    12          1008                 1016
=> passed    16          1584                 1592
=> passed    20          2288                 2296
=> passed    36          6384                 6392
=> passed    72         23088                23096
=> passed   120         61488                61496
==> 8/8 tests passed

Total: 8/8 tests passed!

Student   memory = 4.00 N^2 + 32.00 N + 48.00  (R^2 = 1.000)
Reference memory = 4.00 N^2 + 32.00 N + 56.00  (R^2 = 1.000)

================================================================



******************************************************************************
*  timing
******************************************************************************

Timing Solver
*-----------------------------------------------------------
Running 17 total tests.

Timing tests use your implementation of Board.java and Solver.java. Maximum allowed time per puzzle is 15 seconds.

                                                              delMin()
               filename   N    seconds    insert()          + delMax()         max PQ size
---------------------------------------------------------------------------------------------
=> FAILED  puzzle20.txt   3     1.69       6960   (1.3x)       2574                4387   (2.1x)
Aborting tests: puzzle21.txt took 21.817 seconds to complete.
==> 0/17 tests passed

Total: 0/17 tests passed!

================================================================
