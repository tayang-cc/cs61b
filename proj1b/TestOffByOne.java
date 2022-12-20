import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne1(){
        Character x = 'a', y = 'A';
        assertEquals(false,offByOne.equalChars(x,y));
    }

    @Test
    public void testOffByOne2(){
        Character x = 'a', y ='b';
        assertEquals(true,offByOne.equalChars(x,y));
    }
}
