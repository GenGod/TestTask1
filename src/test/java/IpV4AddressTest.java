import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Богдан on 10.12.2016.
 */
public class IpV4AddressTest {

    @Test
    public void testSubstraction0() throws Exception{
        IpV4Address add0 = null;
        IpV4Address add1 = new IpV4Address("ad.re.tf.ass");
        assertEquals (Main.substraction(add0, add1), 0l);
    }

    @Test
    public void testSubstraction1() throws Exception{
        IpV4Address add0 = new IpV4Address("ad.re.tf.ass");
        IpV4Address add1 = new IpV4Address("256.300.400.-2");
        assertEquals(Main.substraction(add0, add1), 255255255002l);
    }
    @Test
    public void testSubstraction2() throws Exception{
        IpV4Address add0 = new IpV4Address("256.300.400.-2");
        IpV4Address add1 = new IpV4Address(null);
        assertEquals(Main.substraction(add0, add1), 255255255002l);
    }
    @Test
    public void testSubstraction3() throws Exception{
        IpV4Address add0 = new IpV4Address(null);
        IpV4Address add1 = new IpV4Address("192.156.100.5");
        assertEquals(Main.substraction(add0, add1), 192156100005l);
    }
    @Test
    public void testSubstraction4() throws Exception{
        IpV4Address add0 = new IpV4Address("192.156.100.5");
        IpV4Address add1 = new IpV4Address("ad1.20e.t5f.a99");
        assertEquals(Main.substraction(add0, add1), 192156100005l);
    }
}
