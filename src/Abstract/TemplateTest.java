package Abstract;

/**
 * @Description: 模板方法的设计模式
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/05
 * @node:
 *        1. 案例测试：判断计算1000以内的质数的时间
 */

public class TemplateTest {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.spendTime();
    }
}

// 此时将code()函数设置为抽象方法（或模板），子类重写该模板
abstract class Template {
    public void spendTime() {
        // 1. 获取当前时间
        long startTime = System.currentTimeMillis();
        // 2. 执行相应代码
        this.code();
        // 3. 计算执行到当前代码的时间
        long endTime = System.currentTimeMillis();

        // 3. 输出code() 执行的时间
        System.out.println("running time: " + (endTime - startTime));

    }

    public abstract void code();
}

class SubTemplate extends Template {
    @Override
    public void code() {
        // 此时计算1000以内的质数
        for (int i = 2; i <= 1000; ++i) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); ++j) {
                // 如果i%j == 0，则表示i不是质数
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }

            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}