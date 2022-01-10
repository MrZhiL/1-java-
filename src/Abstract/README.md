## 9. 抽象类和抽象方法

随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则一般，更通用。类的设计应该包装父类和子类能够共享特征。有时**将一个父类设计得更加抽象，以至于它没有具体的实例，这样的类叫做抽象类**。

### 9.1 abstract 关键字的使用

1. abstract ： 抽象的

2. abstract 可以用来修饰的结构：类、方法

3. abstract 修饰类：抽象类 

   - 此类不能实例化 `abstract class Person {}`

   - 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
   - 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关工作。

4. abstract 修饰方法：抽象方法 

   - 抽象方法只有方法声明，没有方法体。如，`public abstract void eat();`
   - 包含抽象方法的类一定是一个抽象类。反之，抽象类中可以没有抽象方法。
   - **继承抽象类的子类必须重写父类中的抽象方法** / **将子类也标记为抽象类**
   - 若子类重写了父类中的所有的抽象方法，此子类方可实例化对象
   - 若子类没有重写父类中所有的抽象方法，则子类也必须标记为抽象类，需要使用 abstract

### 9.2 抽象方法的使用场景

- 在航运公司系统中，Vehicle类需要定义两个方法分别计算 运输工具的燃料效率 和 行驶距离。

  问题：卡车（Truck）和驳船（RiverBarge）的燃料效率和行驶距离的计算方法完全不同。因此Vehicle类不能提供计算方法，但子类可以。

### 9.3 abstract 使用中的注意事项：

1. abstract 不能用来修饰：属性、构造器等结构
2. abstract 不能用来修饰**私有方法**（因为私有方法不可以被子类重写）、静态方法（因为静态方法全局只有一份）、final的方法（final修饰的方法不可被重写）、final修饰的类（final修饰的类不可以被继承）



### 9.4 抽象类的练习

1. 为什么抽象类不可以使用final关键字声明？：因为final修饰的类不可以被继承，被finial修饰的方法不可以被重写（正好与抽象类冲突）

2. 一个抽象类中可以定义构造器吗？：可以

3. 是否可以这样理解：

   抽象类就是比普通类多定义了抽象方法，除了不能直接进行类的实例化操作之外，并没有任何的不同？

   答：**不对**。抽象类中不一定有抽象方法

```java
package Abstract;

/**
 * @Description: 抽象类和抽象方法测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/04
 * @node: 抽象类和抽象方法测试，具体的注释在 README.md
 * 
 *        abstract 关键字的使用
 * 
 *        1. abstract 可以用来修饰的结构：类、方法
 * 
 *        2. abstract 修饰类：抽象类
 * 
 *        - 此类不能实例化 `abstract class Person {}`
 * 
 *        - 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
 *        - 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关工作。
 * 
 *        3. abstract 修饰方法：抽象方法
 * 
 *        - 抽象方法只有方法声明，没有方法体。如，`public abstract void eat();`
 *        - 包含抽象方法的类一定是一个抽象类。反之，抽象类中可以没有抽象方法。
 *        - **继承抽象类的子类必须重写父类中的抽象方法** / **将子类也标记为抽象类**
 *        - 若子类重写了父类中的所有的抽象方法，此子类方可实例化对象
 *        - 若子类没有重写父类中所有的抽象方法，则子类也必须标记为抽象类，需要使用 abstract
 * 
 * 
 */
public class AbstractTest {
    public static void main(String[] args) {
        // 1.1 抽象类不能实例化对象
        // Person p = new Person(); // error, 抽象类不能实例化对象
    }
}

// 1. 在class前加abstract，将其声明为抽象类
abstract class Person {
    private int age;
    private String name;

    // 1.2 抽象类中一定有构造器，便于子类实例化时调用
    Person() {

    }

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public abstract void eat();
    // {
    // System.out.println("Person will eat food!");
    // }

    public abstract void breath();
    // {
    // System.out.println("Person will breath");
    // }

}

class Student extends Person {
    Student() {
        super();
    }

    // 1.3 子类可以调用父类中构造器来初始化对象
    Student(String name, int age) {
        super(name, age);
    }

    public void eat() {
        System.out.println("Student will eat food!");
    }

    public void breath() {
        System.out.println("Student will breath");
    }
}

// 2. 如果存在抽象方法，则该类一定为抽象类，否则会报错
// class Person2 { // error, 必须将其也声明为抽象类
abstract class Person2 {
    private int age;
    private String name;

    Person2() {

    }

    Person2(String name, int age) {
        this.age = age;
        this.name = name;
    }

    // 2.1 如果将其声明为抽象方法，则必须将该类也声明为抽象类
    public abstract void eat();

    // public void eat() {
    // System.out.println("Person will eat food!");
    // }
}

// 2.2 如果父类中存在抽象方法，方法一：可以将其也声明为抽象类
abstract class Student2 extends Person2 {
    Student2() {
        super();
    }

    Student2(String name, int age) {
        super(name, age);
    }

    public abstract void show();
}

// 2.3 如果父类中存在抽象方案，方法二：子类重写父类（父类的父类）中的所有抽象方法
class Senior extends Student2 {
    @Override
    public void eat() {
        System.out.println("必须重写父类（包括父类的父类）中所有的抽象方法");
    }

    @Override
    public void show() {
        System.out.println("必须重写父类中所有的抽象方法");
    }
}

```



### 9.5 创建抽象类的匿名子类对象

抽象类的匿名子类

```java
package Abstract;
