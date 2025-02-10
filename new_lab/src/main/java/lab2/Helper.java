package lab2;

import java.util.ArrayList;
import java.util.Random;

public class Helper {

    private Random r = new Random();

    public Helper() {
    }

    /**
     * @param N size of vector to generate
     * @return a vector of size N with random numbers from 0 to 100
     */
    public int[] GenerateRandomIntVector(int N) {
        int[] vec = new int[N];
        for (int i = 0; i < N; i++) {
            vec[i] = r.nextInt(100);
        }

        return vec;
    }

    /**
     * Generates pairs of indices out of an array
     * 
     * @param N size of array
     */
    public ArrayList<int[]> GenerateIndexPairs(int N) {

        Boolean[][] visited = new Boolean[N][N];
        for (int k = 0; k < visited.length; k++) {
            for (int l = 0; l < visited.length; l++) {
                visited[k][l] = false;
            }
        }
        ArrayList<int[]> pairs = new ArrayList<int[]>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || visited[j][i]) {
                    continue;
                }
                if (i != j) {
                    int[] tuple = { i, j };
                    pairs.add(tuple);
                    visited[i][j] = true;
                    visited[j][i] = true;
                }
            }
        }
        return pairs;
    }

    public int GenerateValue() {
        int val = 0;
        while (val == 0 || val < 0) {
            val = r.nextInt(100);
        }
        return val;
    }

    /**
     * Generate n random arrays of 5 elements with:
     * 2 negative values, 1 zero value, 2 positive values
     * 
     * @param n amount of typical-value arrays
     * @return A vector of n random arrays with 5 elements
     */
    public int[][] GenerateTypicalValues(int n) {
        int[][] typicalValues = new int[n][5];
        for (int i = 0; i < n; i++) {
            int[] subarray = { -(GenerateValue()), -(GenerateValue()), 0, GenerateValue(),
                    GenerateValue() };
            typicalValues[i] = subarray;
        }
        return typicalValues;
    }

    public int[] GenerateTypicalKeyValues() {
        int[] typicalValues = { -(GenerateValue()), -(GenerateValue()), 0, GenerateValue(), GenerateValue() };
        return typicalValues;
    }

    /**
     * @param arr, an array of arrays (with subarray length = 5)
     * @return def, returns a vector with default value based on one of the values
     *         in the subarrays
     */
    public int[] GenerateDefaultValues(int[][] arr) {
        int[] def = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int idx = r.nextInt(arr[i].length - 1);
            def[i] = arr[i][idx];
        }
        return def;
    }
}