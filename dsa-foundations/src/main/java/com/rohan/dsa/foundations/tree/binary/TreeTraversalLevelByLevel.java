package com.rohan.dsa.foundations.tree.binary;

/**
 * Given a binary tree print each level on new line.
 *
 * e.g           10
 *           5         15
 *         0   -1    2    6
 * Output :   10
 *            5 15
 *            0 -1 2 6
 *
 * Solution
 * Technique 1:
 * Use 2 queue. Keep polling from q1 and offer to q2 till q1 is empty.
 * After that print a new line. Keep polling from q2 and offer to q1
 * till q2 is empty. Keep doing this still both q1 and q2 are empty.
 *
 * Technique 2
 * Use one queue with delimiter. Add a delimiter null after every level.
 * As soon as you encounter a null print a new line and add null at end of queue
 *
 * Technique 3
 * Use one queue with count. Keep count of nodes at every level. As soon as this
 * count is 0 print a new line.
 *
 * Time space complexity for all above algorithm is O(n).
 */
public class TreeTraversalLevelByLevel {


}
