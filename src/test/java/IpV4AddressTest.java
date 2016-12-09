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
        assertEquals(Main.printAddresses(add0, add1), 0);
    }

    @Test
    public void testSubstraction1() throws Exception{
        IpV4Address add0 = new IpV4Address("ad.re.tf.ass");
        IpV4Address add1 = new IpV4Address("0.0.20.-2");
        assertEquals(Main.substraction(add0, add1), -20002l);
        assertEquals(Main.printAddresses(add0, add1), 4866);
    }
    @Test
    public void testSubstraction2() throws Exception{
        IpV4Address add0 = new IpV4Address("0.0.20.-2");
        IpV4Address add1 = new IpV4Address(null);
        assertEquals(Main.substraction(add0, add1), 20002l);
        assertEquals(Main.printAddresses(add0, add1), 4866);
    }
    @Test
    public void testSubstraction3() throws Exception{
        IpV4Address add0 = new IpV4Address(null);
        IpV4Address add1 = new IpV4Address("ad.re.tf.ass");
        assertEquals(Main.substraction(add0, add1), 0l);
        assertEquals(Main.printAddresses(add0, add1), 0);
    }
    @Test
    public void testSubstraction4() throws Exception{
        IpV4Address add0 = new IpV4Address("0.0.-20.-2");
        IpV4Address add1 = new IpV4Address("ad1.20e.t5f.a99");
        assertEquals(Main.substraction(add0, add1), 20002l);
        assertEquals(Main.printAddresses(add0, add1), 4866);
    }
}
