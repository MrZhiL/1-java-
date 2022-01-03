package BlockTest;

/**
 * @Description: final 关键字（类似于C++中的const关键字）
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/03
 * @summary: final : 最终的
 * 
 *           1 final 可以用来修饰的结构: 类、方法、变量
 * 
 *           2 final 用来修饰一个类
 *           - 用final修饰的类，不可以被继承，比如，String类、System类、StringBuffer类
 *           - ```java
 *           final class FinalA {
 * 
 *           }
 * 
 *           class B extends FinalA {} // error，final修饰的类不能被继承
 *           ```
 * 
 *           3 final 用来修饰方法
 *           - 用final修饰方法，表示方法不可以被重写, 比如Object中的getClass()
 *           - ```java
 *           class AA {
 *           public final void show() {}
 *           }
 * 
 *           class BB extends AA {
 *           public void show() {}; // error，被final修饰的方法不可以被重写
 *           }
 *           ```
 *           4 final 用来修饰变量
 *           - 此时的 “变量” 就称为一个常量，不可以再被改变
 * 
 *           4.1 final修饰属性：
 *           - 可以考虑赋值的位置有：显示初始化、在代码块中赋值（初始化）、在构造器中初始化、
 *           - **note：如果在构造器中赋值，则需要在定义的所有构造器中初始化，否则会报错**
 *           - 不可以通过“类名.属性" 或 ”类名.方法“ 来初始化，因为当类对象创建的时候，类中的属性和方法就已经被创建了
 * 
 *           4.2 final修饰局部变量：
 *           - final修饰形参时，不可以被修改，此时形参为一个常量（类似于C++中的const）
 * 
 *           5 static final ：可以用来修饰属性、方法
 *           - static final 修饰属性：表示全局常量
 *           - static final 修饰方法：表示一个不可被重写的方法，直接可以通过类名调用
 * 
 *           6. 如果final修饰类的实例化对象，则类中的属性仍可以被修改
 */
public class FinalTest {

    // 4. static final 修饰属性的时候，表示全局变量
    static final int G_NUM = 1;

    // 3.1 final修饰变量：
    final int WIDTH = 0; // 显示初始化
    final int LEFT; // 通过代码块初始化
    final int RIGHT; // 通过构造函数初始化，如果定义多个构造函数，必须每个构造函数都初始化

    {
        LEFT = 1;
    }

    public FinalTest() {
        RIGHT = 1;
    }

    public FinalTest(int right) {
        RIGHT = right; // 如果定义多个构造函数，必须每个构造函数都初始化
    }

    public void setRight(int right) {
        // this.RIGHT = right; // error，不可以通过在方法中初始化，因为当类的实例创建时，内存中已经加载了所有的属性和方法
    }

    // 3.2 final修饰局部变量：
    public void show() {
        final int NUM = 10; // 此时NUM不可被修改
        // NUM = 11; // error
    }

    // 3.3 fiinal修饰局部变量，并做形参（类似于C++中的const）
    public int show(final int num) {
        // num = 1; //error
        int k = num;// right, 可以被赋值
        // return num++; // error

        return num + 1; // right
    }

    public static void main(String[] args) {
        FinalA f = new FinalA();
        System.out.println(f.i); // 0
        new FinalTest().addOne(f);
        System.out.println(f.i); // 1
    }

    // 5. 如果final修饰类的实例化对象，则类中的属性仍可以被修改
    public void addOne(final FinalA f) {
        f.i++; // right
    }
}

// 1. final 用来修饰类 ： final修饰的类不能被继承
final class FinalA {
    public int i;

}

// class B extends FinalA {} // error，final修饰的类不能被继承

// 2. final 用来修饰方法 ：被final修饰的方法不可以被重写
class AA {
    public final void show() {
    }
}

class BB extends AA {
    // public void show() {}; // error，被final修饰的方法不可以被重写
}