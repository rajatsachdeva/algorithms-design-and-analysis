package utilities;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class SampleTestRunnerUsage extends HandyTestRunner {

    private static SampleTestRunnerUsage _instance = new SampleTestRunnerUsage();

    public boolean _solutionOne(boolean returnValue) {
        return returnValue;
    }

    public boolean _solutionTwo(boolean returnValue) {
        return returnValue;
    }

    public static void main(String[] args) {
        _instance.runTest(true, true);
        _instance.runTest(false, false);
        _instance.runTest(false, true);
    }

    private void runTest(final boolean input, final boolean expectedOutput) {
        List<Object> answers = runAll(getClass(), new Object[]{input});
        for (Object answer : answers)
            assertThat((boolean) answer).isEqualTo(expectedOutput);

        System.out.println("ok!");
    }

}
