package lab2;

import java.util.*;

/* Question 3 */

public class Lab2 {
    
    public Lab2() {}

    /* Bubble sort */
    public void Sort(int[] numbers){
        int n = numbers.length;
        boolean swap; 
        for (int i=0; i< n-1;i++ ){
            swap=false; 
            for (int j=0; j< n-i-1;j++ ){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j+1]; 
                    numbers[j+1] = numbers[j]; 
                    numbers[j] = temp; 
                    swap = true; 
                }
            }
            if (!swap){
                break;
            }
            }
    }


    public int BinarySearch(int[] numbers, int key){
        int x; int l; int r; 
        l = 0;
        r = numbers.length - 1;

        do {
            x = (l + r)/2;
            if (key < numbers[x]){
                r = x - 1;
            }
            else {
                l = x + 1;
            }
        }
        while (key != numbers[x] && l <= r);

        if (key == numbers[x]){
            return x; 
        }
        else {
            return -1;
        }
    }

    /* membership queries on unsorted arrays of arbitrary length, by combining
        program (i) with program (ii) */
    public boolean Member(int[] numbers, int key){
        Sort(numbers);
        if (BinarySearch(numbers, key) == -1){
            return false;
        } else {
            return true;
        }
    }

    // public static void main(String[] args) {
    //     Lab2 l = new Lab2();
    //     int[] test_sort1 = {1,23,4,2,4,1,0,8};
    //     System.out.println(l.Member(test_sort1, 7000));
    //     System.out.println(l.Member(test_sort1, 0));
    //     System.out.println(l.Member(test_sort1, 4));
        
    //     for (int i = 0; i < test_sort1.length ; i++) {
    //         System.out.println(test_sort1[i]);
    //     }
    // }


}
