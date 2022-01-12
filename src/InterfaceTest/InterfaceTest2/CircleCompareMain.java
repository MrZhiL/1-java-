package InterfaceTest.InterfaceTest2;

/**
 * @Description: 使用接口比较两个类的大小
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 13:01
 * @node: main函数
 *        定义一个测试类InterfaceTest，
 *        创建两个CompareableCircle对象，调用compareTo方法比较两个类的半径大小。
 */
public class CircleCompareMain {
    public static void main(String[] args) {
        CompareableCircle c1 = new CompareableCircle(2.14);
        CompareableCircle c2 = new CompareableCircle(2.14);

        int compareResult = c1.compareTo(c2);
        if (compareResult > 0) {
            System.out.println("c1 > c2");
        } else if (compareResult < 0) {
            System.out.println("c1 < c2");
        } else {
            System.out.println("c1 == c2");
        }
    }
}
