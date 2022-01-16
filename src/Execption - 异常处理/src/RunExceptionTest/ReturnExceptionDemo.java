package RunExceptionTest;

/**
 * @Description: 异常测试1
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/16 09:25
 * @node: 异常联系：基本使用
 */
public class ReturnExceptionDemo {
    // 1. 创建异常1
    static void method1() {
        try {
            System.out.println("Input Method A");
            // 在抛出异常前会先处理finally语句块中的代码，因此“用A方法的finally”会优先运行
            throw new RuntimeException("制作异常");
        } finally {
            System.out.println("用A方法的finally");
        }
    }

    // 2. 创建method2
    static void method2() {
        try {
            System.out.println("Input Method B");
            return;
        } finally {
            System.out.println("用B方法处理异常");
        }
    }

    public static void main(String[] args) {
        try {
            method1();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------");

        method2();
    }
}
