package lab2;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomTest {
    private final static int N= 20;
    private final static Lab2 l= new Lab2();
    private final static Random rand = new Random();
    private final static Helper help = new Helper();
    
    @Test
    public void Randomtemp(){

        int[] array = {};
        l.Sort(array);
        assertEquals(array.length,0);

    }

    @Test
    public void RandomVectorTestTrue(){
        for(int i=0; i<20; i++){
            int[] vec = help.GenerateRandomIntVector(N);

            // Action for true
            int index=rand.nextInt(0,N-1);
            int key=rand.nextInt(100);
            vec[index]=key;
    
            assertTrue(l.Member(vec, key));

        }
       
    }

    @Test
    public void RandomVectorTestFalse(){
        for(int i=0; i<20; i++){
            int[] vec = help.GenerateRandomIntVector(N);

            int key=rand.nextInt(101, 1000);
            assertFalse(l.Member(vec,key));
        }
    }

}
