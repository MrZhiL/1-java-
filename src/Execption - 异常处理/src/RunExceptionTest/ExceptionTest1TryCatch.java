package RunExceptionTest;

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
 *        2.
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
                System.out.println(e);
                System.out.println("数值转换失败，请检查输入是否正确！");
            } catch (NullPointerException e) {
                System.out.println("出现空指针异常，请检查变量初始化！");
            } catch (Exception e) { // 因为Exception处于高层，因此需要放在后面
                System.out.println("出现异常");
            }

            System.out.println("str = " + str);
        }
    }

}
