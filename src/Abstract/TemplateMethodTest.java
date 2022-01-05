package Abstract;

/**
 * @Description: 模板方法的设计模式
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/05
 * @node:
 *        2. 案例测试：银行模板
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        // 模板测试
        BankTemplateMethod draw = new DrawMoney();
        draw.process();

        System.out.println("****************************");

        BankTemplateMethod manager = new ManageMoney();
        manager.process();
    }

}

abstract class BankTemplateMethod {
    // 具体方法
    public void takeNumber() {
        System.out.println("取号排队");
    }

    // 办理具体的业务//钩子方法
    public abstract void transact();

    public void evaluate() {
        System.out.println("反馈评分");
    }

    // 模板方法，把基本操作组合到一起，子类一般不能重写
    public final void process() {
        takeNumber();
        transact(); // 像个钩子，具体执行时，就要看是哪个子类调用
        evaluate();
    }
}

class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("取钱中...");
    }
}

class ManageMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("理财中..., 这里有现金1000万美元");
    }
}
