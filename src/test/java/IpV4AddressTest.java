import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Богдан on 10.12.2016.
 */
public class IpV4AddressTest {

    @Test
    public void test0() throws Exception{
        IpV4Address add0 = null;
        IpV4Address add1 = new IpV4Address("ad.re.tf.ass");
        assertEquals (Main.substraction(add0, add1), 0l);
        assertEquals(Main.printAddresses(add0, add1), 0);
        assertEquals(Main.increment(add0).toString(), new IpV4Address("0.0.0.1").toString());
    }

    @Test
    public void test1() throws Exception{
        IpV4Address add0 = new IpV4Address("ad.re.tf.ass");
        IpV4Address add1 = new IpV4Address("0.0.20.-2");
        assertEquals(Main.substraction(add0, add1), -20002l);
        assertEquals(Main.printAddresses(add0, add1), 5121);
        assertEquals(Main.increment(add1).toString(), new IpV4Address("0.0.20.3").toString());
    }

    @Test
    public void test2() throws Exception{
        IpV4Address add0 = new IpV4Address("0.0.20.-2");
        IpV4Address add1 = new IpV4Address(null);
        assertEquals(Main.substraction(add0, add1), 20002l);
        assertEquals(Main.printAddresses(add0, add1), 5121);
        assertEquals(Main.increment(add0).toString(), new IpV4Address("0.0.20.3").toString());
    }

    @Test
    public void test3() throws Exception{
        IpV4Address add0 = new IpV4Address("192.168.0.250");
        IpV4Address add1 = new IpV4Address("192.168.1.0");
        assertEquals(Main.substraction(add0, add1), -750l);
        assertEquals(Main.printAddresses(add0, add1), 5);
        assertEquals(Main.increment(add1).toString(), new IpV4Address("192.168.1.1").toString());
    }

    @Test
    public void test4() throws Exception{
        IpV4Address add0 = new IpV4Address("0.0.-20.-2");
        IpV4Address add1 = new IpV4Address("ad1.20e.t5f.a99");
        assertEquals(Main.substraction(add0, add1), 20002l);
        assertEquals(Main.printAddresses(add0, add1), 5121);
        assertEquals(Main.increment(add1).toString(), new IpV4Address("0.0.20.3").toString());
    }
}
