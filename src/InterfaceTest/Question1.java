package InterfaceTest;

/**
 * @Description: 接口中的问题
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 12:30
 * @node: 1 - 如果接口A和类B中存在同名变量x，则class C extends B implements A {} 中的x为什么
 */
class Question1 extends B implements A {
    public void showpX() {
        // System.out.println("x = " + x); // error，此时无法区分调用的哪一个
        System.out.println("super.x = " + super.x); // 通过super关键字可以调用继承的父类中的变量
        System.out.println("A.x = " + A.x); // 因为接口中的变量为全局变量，因此可以通过类名访问

    }

    public static void main(String[] args) {
        Question1 q1 = new Question1();
        q1.showpX();
    }
}

interface A {
    int x = 10;
}

class B {
    int x = 1; //
}
