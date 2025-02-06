import java.util.ArrayList;
import java.util.Random;

public class Helper {

    public Helper(){}

    /*
     * Permutations of N elements, choose 2
     */
    public int Permutations2(int N) {
        int perms = 1;
        for (int i = N; i > (N - 2); i--) {
            perms *= i;
        }
        return perms;
    }

    /**
     * @param N size of vector to generate
     * @return a vector of size N with random numbers
     */
    public int[] GenerateRandomIntVector(int N) {
        Random rand = new Random();
        int[] vec = new int[N];
        for (int i = 0; i < N ; i++) {
            vec[i] = rand.nextInt(100);
        }
        return vec;
    }

    /**
     * Generates pairs of indices out of an array
     * @param N size of array
     */
    public ArrayList<int[]> GenerateIndexPairs(int N){

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
                    int[] tuple = {i, j};
                    pairs.add(tuple);
                    visited[i][j] = true;
                    visited[j][i] = true; 
                }
            }
        }
        return pairs;
    }

    public int GenerateNegativeValue() {
        Random r = new Random();
        int val = 0;
        while(val == 0 || val > 0) {
            val = r.nextInt();
        }
        System.out.println(val);
        return val;
    }

    public int GeneratePositiveValue() {
        Random r = new Random();
        int val = 0;
        while(val == 0 || val < 0) {
            val = r.nextInt();
        }
        // System.out.println(val);
        return val;
    }

    /**
     * Generate n random arrays of 5 elements with:
     * 2 negative values, 1 zero value, 2 positive values
     * @param n amount of typical-value arrays
     * @return A vector of n random arrays with 5 elements
     */
    public int[][] GenerateTypicalValues(int n) {
        int[][] typicalValues = new int[n][5];
        for (int i = 0; i < n; i++) {
            int[] subarray = {GenerateNegativeValue(), GenerateNegativeValue(), 0, GeneratePositiveValue(), GeneratePositiveValue()};
            typicalValues[i] = subarray;
        }
        return typicalValues;
    }

    public static void main(String[] args) {
        Helper help = new Helper();
        int[][] typVal = help.GenerateTypicalValues(5);
        for (int[] arr : typVal) {
            String s = "";
            for (int i = 0; i < arr.length; i++) {
                s += arr[i] + " ";
            }
            System.out.println(s);
            System.out.println("----------------");
        }
        // System.out.println(help.GeneratePairs(3));
        // System.out.println(help.Permutations2(20));
    }
}
