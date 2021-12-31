package StaticTest;

/**
 * @Description: main()方法的使用说明
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2021/12/31
 * @node: main() 方法的使用说明：
 * 
 *        1. main() 方法作为程序的入口
 *        2. main() 方法也是一个普通的静态方法
 *        3. main() 方法可以作为我们与控制台交换的一种方法（之前是Scanner）
 * 
 */

public class MainTest {
    public static void main(String[] args) {
        // 1. 在main方法中可以调用其他类的main方法
        Main.main(new String[10]);

        // 2. main方法中的args可以作为输入
        // 在控制台中使用java MainTest aaa bbb ccc
        for (int i = 0; i < args.length; ++i) {
            System.out.println("************ " + args[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            args[i] = "args_" + i;
            System.out.println("************ " + args[i]);
        }
    }
}
