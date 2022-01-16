package RunExceptionTest;

/**
 * @Description: 自定义异常类
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/16 09:10
 * @node: 自定义异常类注意事项：
 *        1. 需要继承与现有的异常结构：RuntimeException、Exception
 *        2. 提供一个全局常量 `serialVersionUID`，每个异常类有一个唯一的并且不同的UID。
 *        3. 提供重载的构造器
 */

// 1. 需要继承与现有的异常结构：RuntimeException、Exception
public class MyExceptionClass extends RuntimeException {
    // 2. 提供一个全局常量 `serialVersionUID`，每个异常类有一个唯一的并且不同的UID。
    static final long serialVersionUID = -7034897190745766939L;

    // 3. 提供重载的构造器
    public MyExceptionClass() {

    }

    public MyExceptionClass(String msg) {
        super(msg);
    }
}
