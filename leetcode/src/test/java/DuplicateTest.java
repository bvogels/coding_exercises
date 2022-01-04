import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateTest {

    @Test
    void containsDuplicate1() {
        Duplicate d = new Duplicate();
        int[] nums = new int[]{1,2,3,1};
        boolean expected = true;
        boolean actual = d.containsDuplicate(nums);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void containsDuplicate2() {
        Duplicate d = new Duplicate();
        int[] nums = new int[]{1,2,3,4};
        boolean expected = false;
        boolean actual = d.containsDuplicate(nums);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void containsDuplicate3() {
        Duplicate d = new Duplicate();
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean expected = true;
        boolean actual = d.containsDuplicate(nums);
        Assert.assertEquals(actual, expected);
    }

}