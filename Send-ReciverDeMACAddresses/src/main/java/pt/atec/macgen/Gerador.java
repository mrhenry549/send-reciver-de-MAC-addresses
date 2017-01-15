package pt.atec.macgen;

import java.util.Random;

public class Gerador {

    Random rand;
    String MAC;

    public Gerador() {

        //System.out.println(sb.toString());

    }

    public String randomMACAddress() {
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        StringBuilder sb = new StringBuilder(18);
        for (byte b : macAddr) {
            if (sb.length() > 0) {
                sb.append(":");
            } else { //first byte, we need to set some options
                b = (byte) (b | (byte) (0x01 << 6)); //locally adminstrated
                b = (byte) (b | (byte) (0x00 << 7)); //unicast

            }
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
