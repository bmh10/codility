package timeComplexity;

import org.junit.Assert;
import org.junit.Test;

public class FrogJmp {

    public int solution(int X, int Y, int D) {
        return ((Double)Math.ceil((double)(Y - X) / (double)D)).intValue();
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solution(10, 85, 30));
    }
}
