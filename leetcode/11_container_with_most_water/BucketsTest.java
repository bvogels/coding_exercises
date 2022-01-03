import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BucketsTest {

    @Test
    void maxArea1() {
        Buckets b = new Buckets();
        int[] bucket = new int[]{1,8,6,2,5,4,8,3,7};
        int expected = 49;
        int actual = b.maxArea(bucket);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void maxArea2() {
        Buckets b = new Buckets();
        int[] bucket = new int[]{2,5,3,7,1,4,1,3};
        int expected = 18;
        int actual = b.maxArea(bucket);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void maxArea3() {
        Buckets b = new Buckets();
        int[] bucket = new int[]{1,1};
        int expected = 1;
        int actual = b.maxArea(bucket);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void maxArea4() {
        Buckets b = new Buckets();
        int[] bucket = new int[]{2,2,2,2};
        int expected = 6;
        int actual = b.maxArea(bucket);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void maxArea5() {
        Buckets b = new Buckets();
        int[] bucket = new int[]{1,2,3,4,5,25,24,3,4};
        int expected = 24;
        int actual = b.maxArea(bucket);
        Assert.assertEquals(actual, expected);
    }
}