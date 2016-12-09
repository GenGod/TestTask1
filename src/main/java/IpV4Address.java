import java.util.Scanner;

/**
 * Created by Богдан on 09.12.2016.
 */
public class IpV4Address {

    private short firstPart;
    private short secondPart;
    private short thirdPart;
    private short fourthPart;

    public IpV4Address(String address) {
        String[] addresses = address.split("[.]");
        firstPart = Short.parseShort(addresses[0]);
        secondPart = Short.parseShort(addresses[1]);
        thirdPart = Short.parseShort(addresses[2]);
        fourthPart = Short.parseShort(addresses[3]);
    }

    public void printAll() {
        System.out.println(this.firstPart);
        System.out.println(this.secondPart);
        System.out.println(this.thirdPart);
        System.out.println(this.fourthPart);
    }
}
