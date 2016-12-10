/**
 * Created by Богдан on 09.12.2016.
 */
public class IpV4Address {

    private long add;
    private short[] parts;

    public IpV4Address(String address) {
        parts = new short[4];
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String str[] = address.split("[.]");
            if (str.length == 4) {
                for (int i = 0; i < str.length; i++) {
                    if (str[i].matches("[-+]?\\d+")) {
                        if (Short.parseShort(str[i]) < 256) {
                            parts[i] = (short)Math.abs(Short.parseShort(str[i]));
                        } else {
                            System.out.println("Parts of ip must be less than \"256\"! This part will equals \"255\"");
                            parts[i] = 255;
                        }
                    } else {
                        System.out.println("Ip must contained ONLY digits and dots! This part will equals \"0\".");
                        parts[i] = 0;
                    }
                }
            } else {
                System.out.println("Ip containes only 4 parts! This address will equals \"192.168.0.1\"!");
                parts[0] = 192;
                parts[1] = 168;
                parts[2] = 0;
                parts[3] = 1;
            }
            for (String ad : address.split("[.]")) {
                if (ad.matches("[-+]?\\d+")) {
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
                            } else {
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
                else {
                    stringBuilder.append("000");
                }
            }
            add = Long.parseLong(stringBuilder.toString());
        }catch(NullPointerException e){
                add = 0;
            for (int i = 0; i < 4; i++) {
                parts[i] = 0;
            }
        }
    }

    public void printAll() {
        System.out.println(this.add);
    }

    public long getAdd() {
        return add;
    }

    public short[] getParts() {
        return parts;
    }


    public boolean equals(IpV4Address obj) {
        try {
            return this.toString().equals(obj.toString());
        } catch (NullPointerException e) {
            return false;
        }
    }

    public String toString() {
        try {
            return new String(Short.toString(this.getParts()[0]) + "." +
                     Short.toString(this.getParts()[1]) + "." +
                    Short.toString(this.getParts()[2]) + "." +
                    Short.toString(this.getParts()[3]));
        } catch (NullPointerException e) {
            return "null";
        }
    }
}
