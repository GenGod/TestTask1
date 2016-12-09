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

    public IpV4Address(short firstPart, short secondPart, short thirdPart, short fourthPart) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
        this.thirdPart = thirdPart;
        this.fourthPart = fourthPart;
    }

    public void printAll() {
        System.out.println(this.firstPart);
        System.out.println(this.secondPart);
        System.out.println(this.thirdPart);
        System.out.println(this.fourthPart);
    }

    public short getFirstPart() {
        return firstPart;
    }

    public short getSecondPart() {
        return secondPart;
    }

    public short getThirdPart() {
        return thirdPart;
    }

    public short getFourthPart() {
        return fourthPart;
    }
}
