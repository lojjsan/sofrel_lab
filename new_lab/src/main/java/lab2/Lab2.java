package lab2;

import java.util.*;

/* Question 3 */

public class Lab2 {
    int[] ArrayOfNumbers;
    int key;

    public Lab2(int N) {
        this.ArrayOfNumbers = new int[N];
        this.key = 0;
    }

    
    public int[] getArrayOfNumbers(){
        return ArrayOfNumbers;
    }
    public int getKey(){
        return key;
    }

    public void setKey(int key){
        this.key=key;
    }
    
    public void setArrayOfNumbers(int[] array){
        this.ArrayOfNumbers=array;
    }

    /**
     * Implements Bubble sort on this.ArrayOfNumbers
     */
    //@ requires A !=null
    //@ ensures \old(A).length == A.length && \forall int i; 0<= i < A.length-1; A[i+1] >= A[i] && 
    //@ \forall (int i ; 0 <= i < A.length - 1;
    //@ 	\num_of(int j ; 0 <= j < A.length - 1; \old(A[i]) == \old(A[j])) == 
    //@ 	\num_of(int j; 0 <= j < A.length - 1; \result[j] == \old(A[i])))
    public void Sort() {
        int n = this.ArrayOfNumbers.length;
        boolean swap;
        for (int i = 0; i < n - 1; i++) {
            swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                // if (this.ArrayOfNumbers[j] < this.ArrayOfNumbers[j + 1]) {      //injection 1
                if (this.ArrayOfNumbers[j] > this.ArrayOfNumbers[j + 1]) {
                    int temp = this.ArrayOfNumbers[j + 1];
                    this.ArrayOfNumbers[j + 1] = this.ArrayOfNumbers[j];
                    this.ArrayOfNumbers[j] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }


    /**
     * Searches if this.key is in this.ArrayOfNumbers (sorted list) using binary search algorithm 
     */
    //@ requires A != null && \typeof(key)==int && (\forall int x; 0<= x < A.length - 1; A[x+1] >= A[x])
    //@ ensures \result==x && (\exist int x; 0 <= x < \old(A.length) - 1; \old(A[x])==key)
    //@ also
    //@ requires A != null && \typeof(key)==int && (\forall int x; 0 <=x < A.length - 1; A[x+1] >= A[x])
    //@ ensures \result== -1 && (\forall int x; 0<=x < \old(A.length); \old(A[x]) != key)
    public int BinarySearch() {
        int x;
        int l;
        int r;
        l = 0;
        r = this.ArrayOfNumbers.length - 1;

        do {
            x = (l + r) / 2;
            // if (this.key > this.ArrayOfNumbers[x]) {      //injection 2
            if (this.key < this.ArrayOfNumbers[x]) {
                // r = x + 1;                  //injection 3
                r = x - 1;
            } else {
                // l = x - 1;                  //injection 4
                l = x + 1;
            }

        // } while (this.key != this.ArrayOfNumbers[x] && l > r);        //injection 5
        // } while (this.key != this.ArrayOfNumbers[x] || l <= r);       //injection 6
        } while (this.key != this.ArrayOfNumbers[x] && l <= r);

        if (this.key == this.ArrayOfNumbers[x]) {
            return x;
        } else {
            return -1;
        }
    }

    /*
     * membership queries on this.ArrayOfNumbers (unsorted arrays of arbitrary length), by combining
     * program (i) with program (ii)
     */
    //@ requires A != null && \typeof(key)==int
    //@ ensures \result==true && (\exists int x; 0<= x < A.length - 1; A[x]==key)
    //@ also
    //@ requires A != null && \typeof(key)==int
    //@ ensures \result==false && (\forall int x; 0<=x < A.length - 1; A[x] != key) 
    public boolean Member() {
        Sort();
        if (BinarySearch() == -1) {
            return false;
        } else {
            return true;
        }
    }

}
