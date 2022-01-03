package BlockTest;

/**
 * @Description: 属性赋值的先后顺序
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/03
 * @summary: 执行的先后顺序：1 -> 2 / 5 -> 3 -> 4
 *           1. 默认初始化
 * 
 *           2. 显示初始化 / 5 在代码块中赋值
 * 
 *           3. 构造器中初始化
 * 
 *           4. 有了对象以后，可以通过“对象.属性” 或 “对象.方法” 的方式进行赋值
 * 
 *           5. **在代码块中进行赋值**
 */

public class OrderTest {
    public static void main(String[] args) {
        Order ord = new Order();
        System.out.println("ord.orderId = " + ord.orderId); // ord.orderId = 4

        Order2 ord2 = new Order2();
        System.out.println("ord2.orderId = " + ord2.orderId); // ord2.orderId = 3
    }
}

class Order {
    // note: orderId执行的先后顺序与书写顺序有关（只针对于代码块和显示初始化）
    // 此时先执行显示初始化的赋值，然后执行代码块中的赋值
    int orderId = 3;

    {
        orderId = 4;
    }
}

class Order2 {
    // 此时先执行代码块中的赋值，然后执行显示初始化的赋值
    {
        orderId = 4;
    }

    int orderId = 3;
}