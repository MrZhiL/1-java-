package InnerClass;

/**
 * @Description: 内部类的一个注意点
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 15:30
 * @node: 一个注意点：
 * 
 *        在局部内部类的方法中（比如，show），如果调用局部内部类所声明的方法（比如method）中的局部变量（比如num），则要求**此局部变量需要声明为final的**。
 * 
 *        此时传递的num为一个副本，无法进行修改原版的num。
 * 
 *        - jdk 7及之前版本：要求此局部变量显式的声明为final的。
 *        - jdk 8及以后的版本：可以省略final的声明。
 */
public class InnerClassTest3 {
    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        ic.method();
        System.out.println("****************************");
    }
}

class InnerClass {
    public void method() {
        int num = 10;

        class SubInnerClass {
            public void show() {
                // 此时传递的num为一个副本，无法进行修改原版的num(编译器会自动标识num为final修饰的)
                // num = 20; // error, Local variable num defined in an enclosing scope must be
                // final or effectively final
                System.out.println(num);
            }
        }
    }

}