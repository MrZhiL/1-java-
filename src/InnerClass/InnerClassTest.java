package InnerClass;

/**
 * @Description: 内部类测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 15:01
 * @node:
 *        1. 当一个事物的内部，还有一个部分需要一个完整的结构进行描述，
 *        而这个内部的完整的结构又只为外部事物提供服务，那么整个内部的完整结构最好使用内部类。
 * 
 *        2. 分类：
 *        - 成员内部类：static成员内部类和非static成员内部类
 * 
 *        - 一方面，作为外部类的成员：
 *        -- 2.1 可以调用外部类的结构
 *        -- 2.2 可以被static修饰
 *        -- 2.3 可以被4中不同的权限修饰符修饰
 * 
 *        - 另一方面，作为一个类：
 *        -- 类内可以定义属性、方法、构造器等
 *        -- 可以用final修饰，表示此类不可以被继承（如果没有被final修饰，则可以被继承）
 *        -- 可以被abstract修饰，此时就不可以实例化对象
 * 
 *        - 局部内部类：（不谈修饰符）、匿名内部类、方法、代码块和构造器内
 *
 *        3. 关注如下的三个问题：
 *        - 3.1. 如何实例化成员内部类的对象
 *        - 3.2. 如何在成员内部类中区分调用外部类的结构
 *        - 3.3. 开发中，局部内部类的使用<见InnerClassTest2.java>
 */

public class InnerClassTest {
    public static void main(String[] args) {
        // 3.1 实例化成员内部类的对象

        // 3.1.1 实例化静态内部类
        Person.Dog dog = new Person.Dog();
        dog.func();

        // 3.1.2 实例化非静态类的对象
        // Person.Cat cat = new Person.Cat(); // error
        Person p = new Person();
        Person.Cat cat = p.new Cat(); // right
        cat.func();
        System.out.println("***************");
        cat.display("kit");
    }
}

class Person {
    public int age;
    public String name = "Person";

    public void eat() {
        System.out.println("Person eat food!");
    }

    // 1. 成员内部类
    // 1.1 static成员内部类

    // 2.2 可以被static修饰
    static class Dog {
        String name = "Dog";

        public void func() {
            System.out.println("狗可以看门");
            // eat(); // error，静态结构中不可以调用非静态盖成员
        }
    }

    // 1.2 非static成员内部类

    // 2.3 可以被4中不同的权限修饰符修饰
    protected class Cat extends Person {
        String name = "cat";

        public void func() {
            System.out.println("猫可以撸");

            // 2.1 可以调用外部类的结构
            age = 10;
            super.eat();
            // eat(); // 等价于Person.this.eat();
            Person.this.eat();
        }

        // 3.2.如何在成员内部类中区分调用外部类的结构
        public void display(String name) {
            System.out.println(name); // 调用形参的属性
            System.out.println(this.name); // 调用内部类的属性
            System.out.println(Person.this.name); // 调用外部类的属性
            System.out.println(super.name); // 调用父类中的属性
        }
    }

    // 2. 局部内部类
    // 2.1 可以在方法内定义
    public void show() {
        class InnerWatch {
            public void watch() {
                System.out.println("在方法内定义内部类");
            }
        }
    }

    // 2.2 可以在代码块中定义
    {
        class InnerWatch2 {
            public void watch() {
                System.out.println("在代码块中定义内部类");
            }
        }
    }

    // 2.3 可以在构造器中定义
    public Person() {
        class InnerWatch3 {
            public void watch() {
                System.out.println("在构造器中定义内部类");
            }
        }

    }
}