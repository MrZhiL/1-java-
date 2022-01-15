package RunExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: 异常处理过程一：try-catch-finally
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/14 15:01
 * @node: try-catch-finally
 *        ###
 * 
 *        ```java
 *        try {
 *        // 1. 可能出现异常的代码
 *        } catch(异常类型1 变量名1){
 *        // 2.1 对出现异常的代码的处理
 *        } catch(异常类型2 变量名2){
 *        // 2.2 对出现异常的代码的处理
 *        } catch(异常类型3 变量名3){
 *        // 2.3 对出现异常的代码的处理
 *        } ...
 *        finally {
 *        // 3. 将一定会执行的代码放在这里
 *        }
 *        ```
 *        说明：
 *        1. finally是可选的
 * 
 *        2.
 *        使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象的类型，去catch中进行匹配。
 * 
 *        3.
 *        一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理。**一旦处理完成后，会跳出当前的try-catch结构**（在没有写final的情况下），然后继续执行剩下的代码。
 * 
 *        4. catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓。
 *        catch中的异常类型如果满足子父类要求，则要求子类一定声明在父类的上面。否则会报错。**
 * 
 *        5. 常用的异常对象处理的方法：
 *        - 1. String getMessage();
 *        - 2. printStackTrace(); // 打印堆栈信息
 * 
 *        6. 在try结构中声明的变量，当出了try结构追偿吧，就不可以再调用了。
 *        可以将变量声明在try外面，但是在try的语句块中赋值。
 * 
 *        体会：使用try-catch-finally处理编译时异常，使得程序在编译时不再报错，但是运行时仍可能报错。相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。
 * 
 * 
 */
public class ExceptionTest1TryCatch {
    public static void main(String[] args) {
        // 1. try-catch 异常测试1
        {
            String str = "123";
            str = "abc";
            try {
                int num = Integer.parseInt(str);
                System.out.println("str转换成功，num = " + num);

            } catch (NumberFormatException e) {
                // 在catch中的常用方法 1. String getMessage() 2. printStackTrace()
                // System.out.println(e);
                // System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("数值转换失败，请检查输入是否正确！");
            } catch (NullPointerException e) {
                System.out.println("出现空指针异常，请检查变量初始化！");
            } catch (Exception e) { // 因为Exception处于高层，因此需要放在后面
                System.out.println("出现异常");
            }

            System.out.println("str = " + str);
        }

        // 2. 对编译异常进行try-catch处理
        {
            // 将编译时异常进行try-catch处理，此时可以使得编译不再进行报错
            try {
                File file = new File("hello.txt");
                FileInputStream fis = new FileInputStream(file); //

                // throws FileNotFoundExceptio
                int data = fis.read();
                while (data != -1) {
                    System.out.println((char) data);
                    data = fis.read();
                }

                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
