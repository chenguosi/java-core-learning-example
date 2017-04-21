package org.javacore.io.byteoper;

/**
 * Created by Guosi Chen on 2017/4/21.
 * Long与byte数组转换
 */
public class LongConvertT {

    /**
     * long 转 byte数组
     */
    public static byte[] long2Bytes(long l) {
        byte[] bytes = new byte[8];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (l >> i * 8 & 0xff);// 移位和清零
        }
        return bytes;
    }

    /**
     * byte数组 转 long
     */
    public static long bytes2Long(byte[] bytes) {
        long l = 0;
        for (int i = 0; i < bytes.length; i++) {
            l += (bytes[i] & 0xff) << i * 8;// 移位和清零
        }
        return l;
    }

    /**
     * byte数组 转 long
     */
    public static void main(String[] args) {
        long l = 256;
        byte[] bytes = long2Bytes(l);
        System.out.println(bytes[0] + " " + bytes[1] + " " + bytes[2] + " " + bytes[3] + " " + bytes[4] + " " + bytes[5]
                + " " + bytes[6] + " " + bytes[7]);
        System.out.println(bytes2Long(bytes));
    }
}
