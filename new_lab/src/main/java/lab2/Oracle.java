package lab2;

import java.util.HashMap;
import java.util.Map;

public class Oracle {

    /**
     * Check if arr is null
     * @param arr
     * @param key
     * @return true of the array exists, else false
     */
    public boolean checkIfNull(int[] arr) {
        if (arr == null) {
            return true;
        } else return false;
    }

    /**
     * Checks if the two arrays have the same length
     * @param arr1
     * @param arr2
     * @return true if the arrays have the same length, else false
     */
    public boolean checkIfLengthIsIdentical(int[] oldArr, int[] newArr) {
        if (oldArr.length == newArr.length) return true;
        else return false;
    }

    /**
     * Checks that the newArr is a permutation of oldArr by
     * doing frequency count on all its elements and comparing
     * @param oldArr integer array (original array)
     * @param newArr integer array, new array which should be a permutation of oldArr
     * @return true if the newArr are a permuation of oldArr, else false
     */
    public boolean checkIsPermutationOf(int[] oldArr, int[] newArr) {
        Map<Integer, Integer> oldFreq = new HashMap<Integer, Integer>();
        Map<Integer, Integer> newFreq = new HashMap<Integer, Integer>();

        // Count old frequencies
        for (int oldElem : oldArr) {
            oldFreq.put(oldElem, (oldFreq.get(oldElem) == null) ? 1 : oldFreq.get(oldElem) + 1);
        }
        for (int newElem : newArr) {
            newFreq.put(newElem, (newFreq.get(newElem) == null) ? 1 : newFreq.get(newElem) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : newFreq.entrySet()) {
            int key = entry.getKey();       // Get the key of the newArr
            int freq = entry.getValue();    // Get the frequency of the key
            // If the old array did not contain that element (key) OR the frequency is not the same
            // then return false
            if (oldFreq.get(key) == null || freq != oldFreq.get(key)) { 
                return false;
            }
        }
        return true;
    }

    /**
     * Check that the element key is not in the list
     * @param arr of integers to check whether ...
     * @param key ... is NOT in the list
     * @return true if key is NOT in the list, else false
     */
    public boolean checkElemIsNotInList(int[] arr, int key) {
        for (int elem : arr) {
            if (key == elem) return false;
        }
        return true;
    }

    /**
     * Check that the element key is in the list
     * @param arr of integers to check whether ...
     * @param key ... is in the list
     * @return true if key is in the list, else false
     */
    public boolean checkElemIsInList(int[] arr, int key) {
        for (int elem : arr) {
            if (elem == key) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the postconditions of the membership
     * @param arr
     * @param key
     * @return
     */
    public boolean checkIsMember(int[] arr, int key) {
        return checkElemIsInList(arr, key);
    }
}
