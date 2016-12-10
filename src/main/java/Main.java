import java.util.Scanner;

/**
 * Created by Богдан on 09.12.2016.
 */
public class Main {

    public static long substraction (IpV4Address minued, IpV4Address subtrahend) {
        try {
            return minued.getAdd() - subtrahend.getAdd();
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

    public static long printAddresses(IpV4Address first, IpV4Address second) {
        try {
            long end = substraction(first, second);
            long count = 0;
            if (end > 0) {
                while(second.getParts()[0] < first.getParts()[0]) {
                    increment(second);
                    System.out.println(second.getParts()[0] + "."
                            + second.getParts()[1] + "."
                            + second.getParts()[2] + "."
                            + second.getParts()[3]);
                    count++;
                }
                while(second.getParts()[1] < first.getParts()[1]) {
                    increment(second);
                    System.out.println(second.getParts()[0] + "."
                            + second.getParts()[1] + "."
                            + second.getParts()[2] + "."
                            + second.getParts()[3]);
                    count++;
                }
                while(second.getParts()[2] < first.getParts()[2]) {
                    increment(second);
                    if (first.getParts()[2] == second.getParts()[2] && first.getParts()[3] == second.getParts()[3])
                        break;
                    System.out.println(second.getParts()[0] + "."
                            + second.getParts()[1] + "."
                            + second.getParts()[2] + "."
                            + second.getParts()[3]);
                    count++;
                }
                while(second.getParts()[3] < first.getParts()[3]) {
                    increment(second);
                    if (first.getParts()[2] == second.getParts()[2] && first.getParts()[3] == second.getParts()[3])
                        break;
                    System.out.println(second.getParts()[0] + "."
                            + second.getParts()[1] + "."
                            + second.getParts()[2] + "."
                            + second.getParts()[3]);
                    count++;
                }
            } else {
                while(first.getParts()[0] < second.getParts()[0]) {
                    increment(first);
                    System.out.println(first.getParts()[0] + "."
                            + first.getParts()[1] + "."
                            + first.getParts()[2] + "."
                            + first.getParts()[3]);
                    count++;
                }
                while(first.getParts()[1] < second.getParts()[1]) {
                    increment(first);
                    System.out.println(first.getParts()[0] + "."
                            + first.getParts()[1] + "."
                            + first.getParts()[2] + "."
                            + first.getParts()[3]);
                    count++;
                }
                while(first.getParts()[2] < second.getParts()[2]) {
                    increment(first);
                    if (first.getParts()[2] == second.getParts()[2] && first.getParts()[3] == second.getParts()[3])
                        break;
                    System.out.println(first.getParts()[0] + "."
                            + first.getParts()[1] + "."
                            + first.getParts()[2] + "."
                            + first.getParts()[3]);
                    count++;
                }
                while(first.getParts()[3] < (second.getParts()[3])) {
                    increment(first);
                    if (first.getParts()[2] == second.getParts()[2] && first.getParts()[3] == second.getParts()[3])
                        break;
                    System.out.println(first.getParts()[0] + "."
                            + first.getParts()[1] + "."
                            + first.getParts()[2] + "."
                            + first.getParts()[3]);
                    count++;
                }
            }
            return count;
        } catch (NullPointerException e) {
            if (first == null) {
                return printAddresses(new IpV4Address("0.0.0.0"), second);
            }
            else if (second == null) {
                return printAddresses(first, new IpV4Address("0.0.0.0"));
            }
            else return printAddresses(new IpV4Address("0.0.0.0"), new IpV4Address("0.0.0.0"));
        }
    }

    public static IpV4Address increment(IpV4Address ad) {
        try {
            if (ad.getParts()[3] < 255) {
                ad.getParts()[3]++;
            } else if (ad.getParts()[2] < 255) {
                ad.getParts()[2]++;
                ad.getParts()[3] = 0;
            } else if (ad.getParts()[1] < 255) {
                ad.getParts()[1]++;
                ad.getParts()[2] = 0;
                ad.getParts()[3] = 0;
            } else {
                ad.getParts()[0] = 0;
                ad.getParts()[1] = 0;
                ad.getParts()[2] = 0;
                ad.getParts()[3] = 0;
            }
            return ad;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return increment(new IpV4Address("0.0.0.0"));
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
        IpV4Address add1 = new IpV4Address(address1);
        printAddresses(add0, add1);
    }
}
