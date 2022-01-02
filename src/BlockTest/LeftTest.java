package BlockTest;

/**
 * @Description: 代码块练习
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/02
 * @summary: 代码块执行：由父及子，静态先行
 */
public class LeftTest {
    public static void main(String[] args) {
        new Leaf();
        System.out.println();
        new Leaf();

        /**
         * output:
         * Root的静态初始化块
         * Mid的静态初始化块
         * Leaf的静态初始化块
         * Root的普通初始化块
         * Root的无参构造器
         * Mid的普通初始化块
         * Mid的无参构造器
         * Mid的带参构造器，其参数值为：Static/non-Static test
         * Leaf的普通初始化块
         * Leaf的无参构造器
         * 
         * Root的普通初始化块
         * Root的无参构造器
         * Mid的普通初始化块
         * Mid的无参构造器
         * Mid的带参构造器，其参数值为：Static/non-Static test
         * Leaf的普通初始化块
         * Leaf的无参构造器
         */
    }
}

class Root {
    static {
        System.out.println("Root的静态初始化块");
    }

    {
        System.out.println("Root的普通初始化块");
    }

    public Root() {
        System.out.println("Root的无参构造器");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid的静态初始化块");
    }

    {
        System.out.println("Mid的普通初始化块");
    }

    public Mid() {
        super();
        System.out.println("Mid的无参构造器");
    }

    public Mid(String msg) {
        this();
        System.out.println("Mid的带参构造器，其参数值为：" + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf的静态初始化块");
    }

    {
        System.out.println("Leaf的普通初始化块");
    }

    public Leaf() {
        super("Static/non-Static test");
        System.out.println("Leaf的无参构造器");
    }
}
