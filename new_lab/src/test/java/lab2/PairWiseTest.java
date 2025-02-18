package lab2;

import java.util.Random;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PairWiseTest {
    private final int N = 20;
    private final Lab2 l = new Lab2(N);
    private final Random r = new Random();
    private final Helper help = new Helper();
    private int typicalLength = 5;
    private final Oracle oracle = new Oracle();

    @Test
    public void PairWiseVectorTest() {
        System.out.println("Running PairWiseVectorTest()\n");
        int testCount = 0;

        // Initialize typical values for all
        int[][] typicalValues = help.GenerateTypicalValues(N);
        int[] typicalKeyValues = help.GenerateTypicalKeyValues();

        int[] def = help.GenerateDefaultValues(typicalValues);
        // int defKey = typicalKeyValues[r.nextInt(typicalLength - 1)];
        int defKey = 0;

        ArrayList<int[]> idxPairs = help.GenerateIndexPairs(N + 1);

        for (int[] pair : idxPairs) {
            testCount++;

            int[] tempArr = def;
            int key = defKey;

            for (int i = 0; i < typicalLength - 1; i++) {
                if (pair[0] == N) {
                    key = typicalKeyValues[i];
                    tempArr[pair[1]] = typicalValues[pair[1]][i];
                } else if (pair[1] == N) {
                    key = typicalKeyValues[i];
                    tempArr[pair[0]] = typicalValues[pair[0]][i];
                } else {
                    tempArr[pair[0]] = typicalValues[pair[0]][i];
                    tempArr[pair[1]] = typicalValues[pair[1]][i];
                }

                // Check if key is in the array                

                l.setArrayOfNumbers(tempArr);
                l.setKey(key);

                //Asserts precondtion
                assertFalse(oracle.checkIfNull(l.getArrayOfNumbers()));

              
                // Asserts that output is the same as expected
                boolean output = l.Member();

                // Create the expected output 
                
                boolean expected = oracle.checkIsMember(l.getArrayOfNumbers(), l.getKey());
                

                if (expected != output) {
                    System.out.println("Expected != Output at test case " + testCount + "\n");
                    assertEquals(expected, output);
                    break;
                }
                assertEquals(expected, output);
            }

        }

    }

}
