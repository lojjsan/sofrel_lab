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
        for (int i = 0; i < 10000; i++) {
            // Initialize vector and key
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

            // Asserts that output is the same as expected
            boolean output = l.Member(arr, key);
            assertEquals(expected, output);

        }

    }

}
