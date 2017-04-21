package org.javacore.io.byteoper;

/**
 * Created by Guosi Chen on 2017/4/20.
 * Integer与byte数组转换
 */
public class IntegerConvertT {

    public static void main(String[] args) {
        // 将我的学号转换成字节码
        byte[] bytes = IntegerConvertT.int2Bytes(257);
        System.out.println(bytes[0] + " " + bytes[1] + " " + bytes[2] + " " + bytes[3]);
        // 字节码就可以转换回学号
        System.out.println(IntegerConvertT.bytes2Int(bytes));
    }

    /**
     * Int转字节数组
     */
    public static byte[] int2Bytes(int i) {
        // 32为的int可存于长度为4的字节数组中
        byte[] bytes = new byte[4];
        for (int j = 0; j < bytes.length; j++) {
            bytes[j] = (byte) (i >> j * 8 & 0xff);// 移位与清零
        }
        return bytes;
    }

    /**
     * 字节数组转Int
     */
    public static int bytes2Int(byte[] bytes) {
        int i = 0;
        for (int j = 0; j < bytes.length; j++) {
            i += (bytes[j] & 0xff) << i * 8; // 移位与清零
        }
        return i;
    }

}
