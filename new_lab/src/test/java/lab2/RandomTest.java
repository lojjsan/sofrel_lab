package lab2;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomTest {

    private final int N = 20;
    private final Lab2 l = new Lab2();
    private final Random rand = new Random();
    private final Helper help = new Helper();

    @Test
    public void RandomVectorTest() {
        System.out.println("Running RandomVectorTest()\n");
        int testCount = 0;

        for (int i = 0; i < 10000; i++) {
            testCount++;

            // Initialize random vector and key
            int[] arr = help.GenerateRandomIntVector(N);
            int key = rand.nextInt(100);

            // Check if key is in the array
            // Create the expected output
            boolean expected = false;

            for (int elem : arr) {
                if (elem == key) {
                    expected = true;
                }
            }

            // // Asserts that output is the same as expected
            // String s = "arr before: [";
            // for (int elem : arr) {
            //     s += elem + " ";
            // }
            // s += "]";
            // System.out.println(s);

            boolean output = l.Member(arr, key);

            // String s1 = "arr after: [";
            // for (int elem : arr) {
            //     s1 += elem + " ";
            // }
            // s1 += "]";
            // System.out.println(s1);

            System.out.println("expected: " + expected);
            System.out.println("output: " + output);

            if (expected != output) {
                System.out.println("Expected != Output at test case " + testCount + "\n");
                assertEquals(expected, output);
                break;
            }
            assertEquals(expected, output);

        }

    }

}
