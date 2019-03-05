package challenges.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Little chief has his own restaurant in the city. There are N workers there. Each worker has his own salary.
 * The salary of the i-th worker equals to Wi (i = 1, 2, ..., N). Once, chief decided to equalize all workers,
 * that is, he wants to make salaries of all workers to be equal. But for this goal he can use only one operation:
 * choose some worker and increase by 1 salary of each worker, except the salary of the chosen worker. In other words,
 * the chosen worker is the loser, who will be the only worker, whose salary will be not increased during this
 * particular operation. But loser-worker can be different for different operations, of course. Chief can use
 * this operation as many times as he wants. But he is a busy man. That's why he wants to minimize the total
 * number of operations needed to equalize all workers. Your task is to find this number.
 * <p>
 * Input
 * The first line of the input contains an integer T denoting the number of test cases. The description of T test
 * cases follows. The first line of each test case contains a single integer N denoting the number of workers.
 * The second line contains N space-separated integers W1, W2, ..., WN denoting the salaries of the workers.
 * <p>
 * Output
 * For each test case, output a single line containing the minimum number of operations needed to equalize all workers.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 100
 * 0 ≤ Wi ≤ 10000 (104)
 * <p>
 * Example:-
 * <p>
 * Input:
 * 2
 * 3
 * 1 2 3
 * 2
 * 42 42
 * <p>
 * Output:
 * 3
 * 0
 * Explanation
 * Example Case 1. Chief can equalize all salaries in 3 turns:
 * <p>
 * Turn ID	IDs of involved workers	Salaries after the move
 * 1	1 2	  2 3 3
 * 2	1 2	  3 4 3
 * 3	1 3	  4 4 4
 * Example Case 2. All salaries are already equal. He doesn't need to do anything.
 * <p>
 * <p>
 * For reference:-
 * <p>
 * <p>
 * http://massivealgorithms.blogspot.com/2016/11/leetcode-453-minimum-moves-to-equal.html
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93886/thinking-process-of-solving-problems-use-java-37ms
 * This is a DP problem. It should be revisited once done, use naive approach
 * <p>
 * TODO: Understand this problem in more detail
 */
public class TheMinimumNumberOfMoves {

    /**
     * Time limit Exceeded.
     */
    private static int minMovesUsingBruteForce(int[] arr, int steps) {
        int max = 0; // Index having maximum value
        int sameCtr = 1; // Atleast 1 element is equal

        // Get the largest value and count the same values
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            } else if (arr[i] == arr[max]) {
                sameCtr++;
            }
        }

        // when length is same
        if (sameCtr == arr.length) return steps;

        // Increment every other element by 1 except the max index.
        for (int i = 0; i < arr.length; i++) {
            if (i != max) {
                arr[i]++;
            }
        }

        return minMovesUsingBruteForce(arr, ++steps);
    }


    /**
     * TODO: Revisit me in future, when you learn about DP
     */
    private static int minMovesUsingDP1(int arr[]) {
        int length = arr.length;
        int sum = 0;
        int min = arr[0];
        for (int val : arr) {
            if (val < min) {
                min = val;
            }
            sum += val;
        }
        return sum - min * length;
    }

    /**
     * TODO: Revisit me in future, when you learn about DP
     */
    private static int minMovesUsingDP2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int step = 0;
        int finalNum = nums[0];

        for (int i = 1; i < n; i++) {
            int tmp = finalNum;
            finalNum = nums[i] + step;
            if (finalNum == tmp) continue;   //attention!!
            step = finalNum - tmp + step;
        }
        return step;
    }


    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            int numTestCases = Integer.parseInt(bufferedReader.readLine());
            while (numTestCases-- > 0) {
                String[] input = bufferedReader.readLine().split(" ");
                int numEmployees = Integer.parseInt(input[0]);
                String[] salariesInString = bufferedReader.readLine().split(" ");
                int salaries[] = new int[numEmployees];
                for (int i = 0; i < numEmployees; i++) {
                    salaries[i] = Integer.parseInt(salariesInString[i]);
                }
                System.out.println(minMovesUsingDP1(salaries));
            }
        } catch (Exception e) {
        }
    }
}
