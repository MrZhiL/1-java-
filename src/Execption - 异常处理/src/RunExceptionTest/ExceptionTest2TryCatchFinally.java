package RunExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: 异常处理过程一：try-catch-finally中finally的使用
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/14 15:01
 * @node: try-catch-finally
 *        1. finally为可选的
 * 
 *        2.
 *        - finally中声明的代码是一定会被执行的，即使catch中又出现异常了，
 *        - try中又return语句，catch中有return语句等情况。
 * 
 *        3. 什么情况下会把代码写到finally之中：
 *        像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源释放。此时的资源当中，就需要声明在finally中。
 * 
 * 
 */
public class ExceptionTest2TryCatchFinally {
    public static void main(String[] args) {
        // test01();
        // test02();

        // System.out.println("test03() = " + test03());

        test04();
    }

    // 1. 无返回值的try-catch-finally 测试
    public static void test01() {
        try {
            int a = 10;
            int b = 0;
            System.out.println("a / b = " + (a / b));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally无返回值测试1，该行代码一定会被执行");
        }
        System.out.println("public static void test01\n");
    }

    // 2. 无返回值的try-catch-finally 测试, 此时在catch语句中仍然会有异常
    public static void test02() {
        try {
            int a = 10;
            int b = 0;
            System.out.println("a / b = " + (a / b));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            // 2.1 下面的代码会抛出异常，然后调用finally中的代码，并退出（不会调用System.out.println(public static void
            // test02)）
            int[] arr = new int[10];
            System.out.println("arr[10] = " + arr[10]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally无返回值测试2，该行代码一定会被执行");
        }

        System.out.println("public static void test02\n");
    }

    // 3. 带返回值的try-catch-finally测试
    public static int test03() {
        try {
            int[] arr = new int[10];
            System.out.println("arr[10] = " + arr[10]);
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("finally返回值测试1");
            // return 3; // 如果finally中存在return语句，则一定会输出该return语句
        }
    }

    // 4. try-catch-finally可以互相嵌套
    // 将编译时异常进行try-catch处理，此时可以使得编译不再进行报错
    public static void test04() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
