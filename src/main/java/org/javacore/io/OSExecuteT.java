package org.javacore.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Guosi Chen on 2017/4/26.
 * 操作系统进程流的案例
 */
public class OSExecuteT {


    public static void commond(String command){
        boolean err = false;

        try {
            //创建操作系统进程
            Process process = new ProcessBuilder(command.split(" ")).start();
            //读取进程的输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }

            //读取进程的错误流
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                if (!err) {
                    err = true;
                }
            }


        } catch (IOException e) {
            if (!command.startsWith("CMD /C")) {
                commond("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
            e.printStackTrace();
        }

        if (err) {
            throw new OSExecuteException("Errors Executing " + command);
        }

    }

    public static void main(String[] args) {
        commond("java -version");
    }

}

class OSExecuteException extends RuntimeException {
    public OSExecuteException() {
    }

    public OSExecuteException(String message) {
        super(message);
    }

    public OSExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public OSExecuteException(Throwable cause) {
        super(cause);
    }

    public OSExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
