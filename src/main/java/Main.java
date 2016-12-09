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
                for (int i = second.getParts()[0]; i < first.getParts()[0] - 1; i++) {
                    for (int j = 0; j < 256; j++) {
                        for (int k = 0; k < 256; k++) {
                            for (int l = 0; l < 256; l++) {
                                System.out.println(i + "." + j + "." + k + "." + l);
                                count++;
                            }
                        }
                    }
                }
                for (int i = 0; i < first.getParts()[1] - 1; i++) {
                    for (int j = 0; j < 256; j++) {
                        for (int k = 0; k < 256; k++) {
                            System.out.println(first.getParts()[0] + "." + i + "." + j + "." + k);
                            count++;
                        }
                    }
                }
                for (int i = 0; i < first.getParts()[2] - 1; i++) {
                    for (int j = 0; j < 256; j++) {
                        System.out.println(first.getParts()[0] + "." + first.getParts()[1] + "." + i + "." + j);
                        count++;
                    }
                }
                for (int i = 0; i < first.getParts()[3]; i++) {
                    System.out.println(first.getParts()[0] + "." + first.getParts()[1] + "." + first.getParts()[2] + "." + i);
                    count++;
                }
            } else {
                for (int i = first.getParts()[0]; i < second.getParts()[0] - 1; i++) {
                    for (int j = 0; j < 256; j++) {
                        for (int k = 0; k < 256; k++) {
                            for (int l = 0; l < 256; l++) {
                                System.out.println(i + "." + j + "." + k + "." + l);
                                count++;
                            }
                        }
                    }
                }
                for (int i = 0; i < second.getParts()[1] - 1; i++) {
                    for (int j = 0; j < 256; j++) {
                        for (int k = 0; k < 256; k++) {
                            System.out.println(second.getParts()[0] + "." + i + "." + j + "." + k);
                            count++;
                        }
                    }
                }
                for (int i = 0; i < second.getParts()[2] - 1; i++) {
                    for (int j = 0; j < 256; j++) {
                        System.out.println(second.getParts()[0] + "." + second.getParts()[1] + "." + i + "." + j);
                        count++;
                    }
                }
                for (int i = 0; i < second.getParts()[3]; i++) {
                    System.out.println(second.getParts()[0] + "." + second.getParts()[1] + "." + second.getParts()[2] + "." + i);
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
        printAddresses(add0, add1);
    }
}
