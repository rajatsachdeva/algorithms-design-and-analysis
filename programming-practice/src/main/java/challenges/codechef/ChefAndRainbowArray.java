package challenges.codechef;


import utilities.InputReaderHelper;

import static java.lang.System.out;

/**
 * Problem Statement:-
 * <p>
 * Chef likes all arrays equally. But he likes some arrays more equally than others. In particular, he loves Rainbow Arrays.
 * <p>
 * An array is Rainbow if it has the following structure:
 * <p>
 * First a1 elements equal 1.
 * Next a2 elements equal 2.
 * Next a3 elements equal 3.
 * Next a4 elements equal 4.
 * Next a5 elements equal 5.
 * Next a6 elements equal 6.
 * Next a7 elements equal 7.
 * Next a6 elements equal 6.
 * Next a5 elements equal 5.
 * Next a4 elements equal 4.
 * Next a3 elements equal 3.
 * Next a2 elements equal 2.
 * Next a1 elements equal 1.
 * ai can be any non-zero positive integer.
 * There are no other elements in array.
 * <p>
 * Help Chef in finding out if the given array is a Rainbow Array or not.
 * <p>
 * Input
 * The first line of the input contains an integer T denoting the number of test cases.
 * The first line of each test case contains an integer N, denoting the number of elements in the given array.
 * The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of array.
 * Output
 * For each test case, output a line containing "yes" or "no" (without quotes) corresponding to the case if the array is rainbow array or not.
 * Constraints
 * 1 ≤ T ≤ 100
 * 7 ≤ N ≤ 100
 * 1 ≤ Ai ≤ 10
 * <p>
 * Subtasks
 * Subtask 1 (100 points) : Original constraints
 * Example
 * Input
 * 3
 * 19
 * 1 2 3 4 4 5 6 6 6 7 6 6 6 5 4 4 3 2 1
 * 14
 * 1 2 3 4 5 6 7 6 5 4 3 2 1 1
 * 13
 * 1 2 3 4 5 6 8 6 5 4 3 2 1
 * <p>
 * Output
 * yes
 * no
 * no
 * Explanation
 * The first example satisfies all the conditions.
 * <p>
 * The second example has 1 element of value 1 at the beginning and 2 elements of value 1 at the end.
 * <p>
 * The third one has no elements with value 7 after elements with value 6.
 */
public class ChefAndRainbowArray {

    private static void solution(int[] rainbowArr) {

        int start = 0;
        int end = rainbowArr.length - 1;
        int current = 0;
        boolean isChefHappy = true;
        while (isChefHappy && start <= end) {

            isChefHappy = (rainbowArr[start] == rainbowArr[end]) &&
                    (rainbowArr[start] < 8) &&
                    ((rainbowArr[start] == current || rainbowArr[start] == current + 1));

            if (rainbowArr[start] == current + 1) {
                current++;
            }

            start++;
            end--;
        }

        out.println(isChefHappy && current == 7 ? "yes" : "no");
    }

    public static void main(String[] args) {
        InputReaderHelper in = new InputReaderHelper(System.in);
        // Test data preparation
        int T = in.readInt();
        while (T-- > 0) {
            int n = in.readInt();
            int[] arr = in.readIntArray(n);

            // Execute one by one
            solution(arr);
        }
        in.close();
    }
}