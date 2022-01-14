package RunExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description: 异常测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/14 15:01
 * @node: 异常体系结构
 * 
 *        java.lang.Throwable
 * 
 *        ​|----------- java.lang.Error: 一般不编写针对性的代码进行处理
 * 
 *        ​|------------java.lang.Exception: 可以进行异常的处理
 * 
 *        |-------------------编译时异常（checked）：IOException（FileNotFoundException）、ClassNotFoundException
 * 
 *        ​|-------------------运行时异常（unchecked, RunExceptionTest）:
 *        NullPointException、ArrayIndexOutofBoundException、ClassCastException、
 *        NumberFormatException、InputMismatchException、ArithmeticException
 */

public class ExceptionTest {
    public static void main(String[] args) {

        /** 一 、 运行时异常 */
        {
            // 1.1. NullPointException 异常
            int[] arr = null;
            // System.out.println(arr[1]); // Exception : java.lang.NullPointException

            // 1.2. ArrayIndexOutofBoundException 异常
            arr = new int[3];
            // System.out.println(arr[3]); // Exception :
            // java.lang.ArrayIndexOutOfBoundsException

            // 1.3. StringIndexOutOfBoundsException 异常
            if (false) {
                String str = new String("abc");
                System.out.println(str.charAt(4));
            }

            // 1.4. ClassCastException 异常
            if (false) {
                Object obj = new Date();
                String str = (String) obj; // Exception : java.lang.ClassCastException
            }

            // 1.5. NumberFormatException 异常
            if (false) {
                String str = "123";
                Integer in = Integer.parseInt(str);
                System.out.println("in = " + in);

                str = "abc";
                in = Integer.parseInt(str); // Exception : java.lanag.NumberFormatException
                System.out.println("in = " + in);
            }

            // 1.6. InputMismatchException 异常
            if (false) {
                Scanner sc = new Scanner(System.in);
                int k = sc.nextInt(); // 如果此时输入不是整数，则会报 java.util.InputMismatchException 异常
                System.out.println("k = " + k);
                sc.close();
            }

            // 1.7. ArithmeticException 异常
            if (false) {
                int a = 10;
                int b = 0; // 分母为0，报 java.lang.ArithmeticException 的异常
                System.out.println(a + " / " + b + " = " + (a / b));
            }
        }

        /** 二、编译时异常 */
        {
            // 2.1 IOException（FileNotFoundException） 异常
            if (false) {
                File file = new File("hello.txt");
                FileInputStream fis = new FileInputStream("file"); // java.io.FileInputStream.FileInputStream(File file)
                                                                   // throws FileNotFoundExceptio
                int data = fis.read();
                while (data != -1) {
                    System.out.println((char) data);
                    data = fis.read();
                }

                fis.close();
            }
        }
    }
}
