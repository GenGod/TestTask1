import java.util.Scanner;

/**
 * Created by Богдан on 09.12.2016.
 */
public class Main {

    public static long substraction (IpV4Address minued, IpV4Address subtrahend) {
        try {
            return Math.abs(minued.getAdd() - subtrahend.getAdd());
        } catch (NullPointerException e) {
            if (minued == null) {
                return subtrahend.getAdd();
            }
            else if (subtrahend == null) {
                return minued.getAdd();
            }
            else return 0;
        }
    }

    public static void main(String[] args) {
        String address0;
        String address1;
        System.out.println("Welcome! Pleas, input olny digits and dot-symbols. Thank you!");
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Input first ip:");
            address0 = s.nextLine();
            if (address0.length() < 7 || address0.length() > 15) {
                System.out.println("Input another ip.");
            }
        }
        while (address0.length() < 7 || address0.length() > 15);
        do {
            System.out.println("Input second ip:");
            address1 = s.nextLine();
            if (address1.length() < 7 || address0.length() > 15) {
                System.out.println("Input another ip.");
            }
        }
        while (address0.length() < 7 || address0.length() > 15);
        IpV4Address add0 = new IpV4Address(address0);
        add0.printAll();
        IpV4Address add1 = new IpV4Address(address1);
        add1.printAll();
        System.out.println(substraction(add0, add1));
    }
}
