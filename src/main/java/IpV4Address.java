import java.util.Scanner;

/**
 * Created by Богдан on 09.12.2016.
 */
public class IpV4Address {

    private long add;

    public IpV4Address(String address) {
        String[] addresses = address.split("[.]");
        add = Long.parseLong(addresses[0].concat(addresses[1].concat(addresses[2].concat(addresses[3]))));
    }

    public void printAll() {
        System.out.println(this.add);
    }

    public long getAdd() {
        return add;
    }
}
