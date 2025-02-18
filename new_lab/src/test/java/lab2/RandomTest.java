package lab2;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomTest {

    private final int N = 20;
    private final Lab2 l = new Lab2(N);
    private final Random rand = new Random();
    private final Helper help = new Helper();
    private final Oracle oracle = new Oracle();

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

            // Asserts precondtion
            assertFalse(oracle.checkIfNull(l.getArrayOfNumbers()));

            l.setArrayOfNumbers(arr);
            l.setKey(key);

            
            boolean output = l.Member();

            // Create the expected output
            boolean expected = oracle.checkIsMember(l.getArrayOfNumbers(), l.getKey());
                
            if (expected != output) {
                System.out.println("Expected != Output at test case " + testCount + "\n");
                // Asserts that output is the same as expected
                assertEquals(expected, output);
                break;
            }
            assertEquals(expected, output);

        }

    }

}
