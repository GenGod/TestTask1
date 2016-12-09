import java.util.Scanner;

/**
 * Created by Богдан on 09.12.2016.
 */
public class IpV4Address {

    private long add;

    public IpV4Address(String address) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (String ad : address.split("[.]")) {
                switch (ad.length()) {
                    case 1: {
                        StringBuilder sb = new StringBuilder(ad);
                        sb.insert(0, "00");
                        stringBuilder.append(sb.toString());
                        break;
                    }
                    case 2: {
                        if (Short.parseShort(ad) > 0) {
                            StringBuilder sb = new StringBuilder(ad);
                            sb.insert(0, "0");
                            stringBuilder.append(sb);
                            break;
                        }
                        else {
                            StringBuilder sb = new StringBuilder(ad);
                            sb.deleteCharAt(0);
                            sb.insert(0, "00");
                            stringBuilder.append(sb.toString());
                            break;
                        }
                    }
                    case 3: {
                        if (Short.parseShort(ad) > 0) {
                            if (Short.parseShort(ad) < 256) {
                                stringBuilder.append(ad);
                            } else {
                                System.out.println("Parts of ip must be less than 256! This part will equals \"255\".");
                                stringBuilder.append("255");
                            }
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(ad);
                            sb.deleteCharAt(0);
                            sb.insert(0, "0");
                            stringBuilder.append(sb);
                            break;
                        }
                    }
                    default: {
                        stringBuilder.append("255");
                    }
                }
            }
            add = Long.parseLong(stringBuilder.toString());
        } catch (NullPointerException e) {
            add = 0;
        }
    }

    public void printAll() {
        System.out.println(this.add);
    }

    public long getAdd() {
        return add;
    }
}
