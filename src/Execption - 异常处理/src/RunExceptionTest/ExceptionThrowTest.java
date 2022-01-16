package RunExceptionTest;

/**
 * @Description: 手动抛出异常测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.2 -- 与用户自定义异常进行关联，去除了部分自动的异常类
 * @data: 2022/01/16 09:10
 * @node: 手动抛出异常：
 *        1. 关于异常对象的产生：系统自动生成的异常对象；
 *        2. 手动的生成一个异常对象，并抛出（**throw**）
 */
public class ExceptionThrowTest {
    public static void main(String[] args) {
        try {
            Person p = new Person();
            p.Register(-11);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Person {
    private int id;

    public void Register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            // 1. 通过打印来通知用户
            System.out.println("输入ID需要为正整数！");

            // 2. 通过throw进行异常的抛出，运行时异常可以不进行处理
            // throw new RuntimeException("throw: 输入ID需要为正整数！");

            // 3. 通过throw进行异常的抛出，非运行时异常必须进行try-catch的处理
            // throw new Exception("throw: 输入ID需要为正整数！");

            // 4. 通过throw 抛出自定义的异常类
            throw new MyExceptionClass("MyException: ID不可以非负数");
        }
    }

    @Override
    public String toString() {
        return "Person[id = " + id + "]";
    }
}
