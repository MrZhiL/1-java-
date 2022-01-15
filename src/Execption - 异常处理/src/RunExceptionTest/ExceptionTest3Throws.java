package RunExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: 异常处理过程二：throws + 异常处理
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/15 14:31
 * @node: throws + 异常处理
 *        1. `throws + 异常类型` 写在方法声明处。指明此方法执行时，可能会抛出异常类型。
 *        一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类对象，此对象满足throws异常类型时，就会被抛出。
 *        此时异常代码后面的代码，就不会再被执行。
 * 
 *        2. 体会：
 *        -1.1. try-catch-finally: 真正的将异常给处理掉了
 *        -2.2. throws的方式只是将异常抛给了方法的调用者，并没有真正的将异常处理掉。
 * 
 * 
 */
public class ExceptionTest3Throws {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        // 接收method2()方法，处理异常
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException {
        // 接收method3()方法，并继续将异常抛给上层
        method3();
    }

    // 1. 使用throws将异常抛给上层
    public static void method3() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while (data != -1) {
            System.out.print(Character.toChars(data));
            data = fis.read();
        }

        if (fis != null) {
            fis.close();
        }

        System.out.println("使用throws抛出异常时，这行代码不会被执行");
    }
}
