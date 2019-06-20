import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void testAdd(){
        MTest mTest = new MTest();
        int res = mTest.add(1,2);
        Assert.assertEquals(3,res);
    }

}
