package InterfaceTest.InterfaceTest2;

/**
 * @Description: 使用接口比较两个类的大小
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 13:00
 * @node:
 *        interface CompareObject {
 *        public int compareTo(Object o); //
 *        如返回值为0，代表相等；若为正数，代表当前对象大；若为复数，代表当前对象小
 *        }
 */
public interface CompareObject {
    // 如返回值为0，代表相等；若为正数，代表当前对象大；若为复数，代表当前对象小
    public int compareTo(Object o);
}
