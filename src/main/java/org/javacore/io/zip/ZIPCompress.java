package org.javacore.io.zip;

import java.io.File;

/**
 * Created by Guosi Chen on 2017/4/21.
 * 利用Zip进行多文件保存
 */
public class ZIPCompress {

    private static String filePath =
            "src" + File.separator + "org" + File.separator + "javacore" + File.separator + "io" + File.separator;

    private static String[] fileNames =
            new String[] { filePath + "BufferedInputFileT.java", filePath + "ChangeSystemOut.java" };

    public static void main(String[] args) {

    }
}
