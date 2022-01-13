##  三、面向对象基础 - 下

## 1. 问题

### 1. 如何实现向下转型？需要注意什么问题？如何解决此问题？

向上转型：多态 (子类-> 父类)

向下转型：逆多态 （父类->子类）

- 使用强制符： () --> Person p = (Person) new Man();

- 可能出现`ClassCastExeption`异常，在向下转型前使用instanceof进行判断

  ```java
  // 如果p为Man的实例化对象，则返回true，否则返回false
  // x instanceof A : 要求x所属的类与类A必须为子父类的关系, 否则会编译错误
  if (p instanceof Man) {
  	Man m = (Man)p;
  }
  ```

- **为什么使用向下转型**：有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。

### 2. == 和 equals() 有何区别

== 表示比较两个类的地址

Object类中的equals()判断的是两个地址是否相同，此时与== 相同

但是String、Date、包装类可以重写equals()方法，此时可以比较两个对象的内容是否相同 



```java
// 重写equals() 方法
public boolean equals(Object obj) {

}
```



### 3. 写出8种基本数据类型及其对应的包装类

int、double、float、char、short、boolean、long、byte

Integer、Double、Float、Character、Short、Boolean、Long、Byte



### 4. 基本数据类型、包装类与String三者之间如何转换

自动装箱、自动拆箱

Integer i = 10;

基本数据类型、包装类--> String: `valueOf(Xxx xxx);`

String --> 基本数据类型、包装类：`parseXxx(String s);`





## 2. 学习内容

该项目为Java中面向对象编程第三部分-对象对象编程下

主要内容包括：

\- 关键字：static

\- 理解main方法的语法

\- 类的成员之四：代码块

\- 关键字：final

\- 抽象类与抽象方法

\- 接口（interface）

\- 类的成员之无：内部类



## 3. 关键字：static

### 3.1 static说明

当我们编写一个类时，其实就是在描述其对象的属性和行为，而并没有产生实质上的对象，只有通过new关键字才会产生出对象，这时系统才会分配内存空间给对象，其方法才可以供外部调用。我们有时候希望无论是否产生了对象或无论产生了多少对象的情况下，**某些特定的数据在内存空间中只有一份**，例如所有中国人都有一个相同的国家名称，每一个中国人可以共享这个国家名称，不必在每个示例化对象中单独分配一个空间来存储国家名。

```
/**
 * static 关键字的使用
 * 
 * 1. static : 静态的
 * 2. static 可以用来修饰：属性、方法、代码块、内部类
 * 
 * 3. 使用static修饰属性：称为 静态变量（类变量）
 * 3.1 属性，按是否使用static修饰，分为：静态属性 、 非静态属性（实例变量）
 * 实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值修改
 * 静态变量：当创建多个类的对象时，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致所有对象的调用此静态变量时，会显示修改过的变量。
 *
 * 3.2 static修饰属性的其它说明：
 * * (1) 静态变量随着类的加载而加载，可以通过 “类名.静态变量” 的方式进行调用。
 * * (2) 静态变量的加载早于对象的创建。
 * * (3) 由于类只会加载一次，则静态变量在内存中也只会存在一份：存在于方法区的静态域中（内存中的静态区）。
 * * (4) 	  类变量	   静态变量
 * * 	类 	  yes 		no
 * * 	对象   yes 		yes
 *
 * 3.3 静态属性举例： System.out; Math.PI;
 *
 * 4. 使用static修饰方法：静态方法
 *		4.1 随着类的加载而加载，可以通过“类.静态方法”的方式进行调用
 *		4.2   静态方法	 非静态方法
 * * 	类 	 yes 		no
 * * 	对象   yes 		yes
 *		4.3 在静态方法中，只能调用静态的方法或属性；对于非静态方法，既可以调用非静态的 ，也可以调用非静态的方法或属性
 *
 * 5. static注意点：
 *		5.1 在静态的方法内，不能使用this关键字、super关键字
 *		5.2 在静态方法中，只能调用静态的方法或属性；对于非静态方法
 *		5.3 对于非静态方法，既可以调用非静态的 ，也可以调用非静态的方法或属性
 *
 */
```

```java
public class StaticTest {
    public static void main(String[] args) {
        Person.nation = "CHN"; // 静态属性可以通过类名直接进行调用，因为所有实例化对象共享同一份内存，且当类加载时静态对象也会自动加载
        System.out.println("Person.nation = " + Person.nation); // Person.nation = CHN

        Person p1 = new Person();
        p1.name = "孙悟空";
        p1.age = 999;
        p1.id = 001;
        System.out.println("p1.nation = " + p1.nation + ", Person.nation = " + Person.nation);
        // 输出： p1.nation = CHN, Person.nation = CHN

        Person p2 = new Person();
        p2.name = "猪八戒";
        p2.age = 888;
        p2.id = 002;
        p2.nation = "China"; // 建议使用 Person.nation，因为nation为静态变量
        System.out.println("p1.nation = " + p2.nation + ", p1.nation = " + p1.nation);
        // 输出：p1.nation = China, p1.nation = China

        System.out.println("********************************");
        p2.test01();
        System.out.println("********************************");
        Person.test02();
    }
}

class Person {
    String name;
    int age;
    long id;

    static String nation; // 静态属性，国家

    // 生成两个非静态方法，两个静态方法
    public void eat01() {
        System.out.println("public void eat01()");
    };

    public void eat02() {
        System.out.println("name = " + this.name + ", age = " + this.age + ", id = " + this.id);
        System.out.println("public void eat02()");
    }

    public static void show01() {
        System.out.println("public static void show01()");
    }

    public static void show02() {
        System.out.println("public static void show02()");
    }

    // 1. 非静态方法既可以调用静态属性、静态方法，也可以调用非静态属性、非静态方法
    // 因为每个实例化对象在内存中都会生成一份非静态属性，因此可以使用this区分开不同的实例化对象
    public void test01() {
        this.name = "孙悟空"; // right, 可以调用非静态属性
        this.eat02(); // right, 可以调用非静态方法
        show01(); // right, 可以调用静态方法，相当于Person.show01();
    }

    // 2. 静态方法只能调用静态属性、静态方法，不可以调用非静态方法、属性
    public static void test02() {
        // Person.name = "1"; // error, 不可以调用非静态属性
        // Person.eat01(); // error, 不可以调用非静态方法

        show01(); // right, 可以调用静态方法
        show02();
        Person.nation = "China"; // right，可以调用静态属性
    }
}

---------------------输出---------------------------
Person.nation = CHN
p1.nation = CHN, Person.nation = CHN
p1.nation = China, p1.nation = China
********************************    
name = 孙悟空, age = 888, id = 2    
public void eat02()
public static void show01()
********************************    
public static void show01()
public static void show02()
```

<img src="D:\Program Files (x86)\JavaProject\Java知识点2 - 面对对象下.assets\image-20211229163317669.png" alt="image-20211229163317669" style="zoom:67%;" />



### 3.2 开发中，如何确定一个属性是否要声明为static？

- 属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
- 类中的常量也通常声明为static



### 3.3 开发中，如何确定一个方法是否要声明为static？

- 操作静态属性的方法，通常设置为static的
- 工具类中的方法，习惯上声明为static的。比如，Math、Arrays、Collections



## 4. 类的加载

类的加载在程序进行运行的时候

类的消亡在当整个类调用结束后，JVM也结束后进行释放



## 5. static应用：单例设计模式(Singleton)

- 设计模式是在大量的时间中总结和理论化之后优选的代码结构、编程风格、以及错误问题的思考方法。设计模式就像是经典的棋谱，不同的棋局，我们用不同的棋谱，避免我们自己再去思考和摸索。
- 所有类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类**只能存在一个对象实例**，并且该类只提供一个取得其对象实例的方法。如果我们要让类在一个虚拟机中只能产生一个对象，我们首先必须将类的构造器的访问权限设置为private，这样，就不能用new操作符在类的外部实例化对象了，但在类内部仍可以产生该类的对象。
- 因为在类的外部开始还无法得到类的对象，只能**调用该类的某个静态方法**以返回类内部创建的对象。静态方法只能访问类中的静态成员变量，所以，指向类内部产生的**该类对象的变量也必须定义成静态的**。
- 有两种单例设计模式：饿汉式（创建静态对象的时候便初始化）和懒汉式（创建静态对象时不初始化）

### 1. 饿汉式单例设计模式

```java
package StaticTest;

/**
 * @Description: 单例设计模式 - 实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2021/12/30
 */

public class SingletonTest1 {
    public static void main(String[] args) {
        // 单例设计模式中，只能实例化一个对象，因此bank1和bank2是相同的，且具有相同的地址
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2); // true
    }
}

// 饿汉式单例设计模式
class Bank {
    // 1. 将构造函数私有化
    private Bank() {

    }

    // 2. 在内部创建类的对象（必须为静态属性）
    private static Bank instance = new Bank();

    // 3. 创建静态方法，返回2中创建的实例化对象
    public static Bank getInstance() {
        return instance;
    }
}

```

### 2. 懒汉式单例设计模式

```
package StaticTest;

/**
 * @Description: 懒汉式单例设计模式 - 实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.2
 * @data: 2021/12/30
 */

public class SiingletonTest2 {
    public static void main(String[] args) {
        Order ord1 = Order.getInstance();
        Order ord2 = Order.getInstance();

        System.out.println(ord1 == ord2); // true
    }
}

// 懒汉式单例设计模式
class Order {
    private Order() {

    }

    // 2. 在内部创建类的对象（必须为静态属性, 不初始化）
    private static Order instance = null;

    // 3. 创建静态方法，返回2中创建的实例化对象
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}
```



### 3. 区分饿汉式和懒汉式单例设计模式

- 饿汉式：
  - 优点：饿汉式是线程安全的
  - 缺点：提前创建对象，导致对象加载时间过程

- 懒汉式：
  - 优点：延迟创建对象
  - 缺点：目前的写法，懒汉式为非线程安全的



### 4. 单例模式的使用场景

1. 网站的计数器 - 一般也是单例模式实现，否则难以同步。
2. 应用程序的日志应用 - 一般都使用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
3. 数据库连接池的设计一般也采用单例模式，因为数据库连接是一种数据库资源。
4. 项目中，读取配置文件的类 - 一般也只有一个对象。没有必要每次使用配置文件数据，都生成一个对象去读取。
5. Application 也是单例的典型应用
6. Windows 的Task Manager(任务管理器)就是很典型的单例模式
7. Windows 的Recycle Bin（回收站）也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。



### 5. 单例设计模式优点

由于单例模式只生成一个实例，**减少了系统性能的开销**，当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接生产一个单例对象，然后永久驻留内存的方式来解决。

- 举例：`java.lang.Runtime`

- ```java
  public class Runtime {
      private static final Runtime currentRuntime = new Runtime();
  
      private static Version version;
  
      /**
       * Returns the runtime object associated with the current Java application.
       * Most of the methods of class {@code Runtime} are instance
       * methods and must be invoked with respect to the current runtime object.
       *
       * @return  the {@code Runtime} object associated with the current
       *          Java application.
       */
      public static Runtime getRuntime() {
          return currentRuntime;
      }
  
      /** Don't let anyone else instantiate this class */
      private Runtime() {}
      
      // ...
  }
  ```

  

## 6. 理解main() 方法的语法

main() 方法的使用说明：

1. main() 方法作为程序的入口

2. main() 方法也是一个普通的静态方法

3. main() 方法可以作为我们与控制台交换的一种方法（之前是Scanner）

4. ```java
   public class MainTest {
       public static void main(String[] args) {
           // 1. 在main方法中可以调用其他类的main方法
           Main.main(new String[10]);
   
           // 2. main方法中的args可以作为输入
           // 在控制台中使用java MainTest aaa bbb ccc
           for (int i = 0; i < args.length; ++i) {
               System.out.println("************ " + args[i]);
           }
       }
   }
   
   class Main {
       public static void main(String[] args) {
           for (int i = 0; i < args.length; ++i) {
               args[i] = "args_" + i;
               System.out.println("************ " + args[i]);
           }
       }
   }
   
   
   ```



**通过`public static void main(String[] args) {// 方法体}` 可以知道：**

- 权限修饰符：private 缺省 protected public --> 封装性
- 修饰符：static \ final \ abstract \ native 可以用来修饰方法
- 返回值类型：无返回值 / 有返回值 --> return
- 方法名：需要满足标识符命名的规则、规范：“见名知意”
- 形参列表： 重载 vs 重写；参数的传递机制；体现对象的多态性
- 方法体：来体现方法的功能



## 7. 类的成员之四：代码块

 类包括：属性、方法、构造器

**该小节主要介绍类的成员之四：代码块（或初始化块）**

1. 代码块作用：用来初始化类、对象

2. 代码块如果有修饰的话，只能使用static

3. 分类：静态代码块 vs 非静态代码块

   **代码块通过一组花括号实现**

4. 静态代码块：

   - 内部可以有输出语句
   - 静态代码块**随着类的加载而执行**（因为为静态的，所有只会加载一次）
   - 作用：随着类的加载而执行，**可以初始化类的信息**。
   - **如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行**
   - 静态代码块的执行要优先于非静态代码块的执行
   - 静态代码块中只能调用静态的属性、静态的方法，不能调用非静态的结构

   ```java
   String static desc;
   static {
   	System.out.println("hello, static block-1");
       desc = "I am a good boy";
       // name = "keik";	// error, 静态代码块不可以调用非静态属性和方法
   }
   
   static {
   	System.out.println("hello, static block-2");
       desc = "I am a good girl";
   }
   ```

   

5. 非静态代码块：

   - 内部可以有输出语句
   - 随着对象的创建而执行，
   - **每创建一个对象，就执行一次次非静态代码块**
   - 作用：可以在创建对象时，对对象的属性等进行初始化
   - **如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行**
   - 静态代码块的执行要优先于非静态代码块的执行
   - 非静态代码块内可以调用静态的属性、方法，以及非静态的属性、方法

   ```java
   int age;
   String name;
   {
   	System.out.println("hello, non-static block-1");
       age = 1;
       name = "jason";
       desc = "hello, 可以调用非静态属性和方法";
   }
   {
   	System.out.println("hello, non-static block-2");
       age = 11;
       name = "jack";
   }
   ```

6. 对属性可以赋值的位置：

   1. 默认初始化

   2. 显示初始化 / 5 在代码块中赋值

   3. 构造器中初始化

   4. 有了对象以后，可以通过“对象.属性” 或 “对象.方法” 的方式进行赋值

   5. **在代码块中进行赋值**

      执行的先后顺序：1 -> 2 / 5 -> 3 -> 4

```java
package BlockTest;

/**
 * @Description: 代码块测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/02
 * @node: 代码块测试，具体的注释在 README.md
 *        1. 代码块作用：用来初始化类、对象
 * 
 *        2. 代码块如果有修饰的话，只能使用static
 * 
 *        3. 分类：静态代码块 vs 非静态代码块
 ** 
 *        代码块通过一组花括号实现**
 */

public class BlockTest {
    public static void main(String[] args) {
        String desc1 = Person.desc; // 会输出hello, static block-1; hello static block-2
        String desc2 = Person.desc; // 会输出hello, static block-1; hello static block-2

        Person p1 = new Person("jason", 21);
        Person p2 = new Person("kiek", 19);

        System.out.println(p1.toString()); // [name = kiek, age = 19]
        System.out.println(p2.toString()); // [name = kiek, age = 19]

        Person p3 = new Person();
        System.out.println(p3.toString()); // [name = non-static-2, age = 22]
    }
}

class Person {
    private int age;
    private String name;
    static String desc;

    // 1. 构造方法
    Person() {

    }

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    // 2. 属性的get and set
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void show() {
        System.out.println("public void show()");
    }

    public static void info() {
        System.out.println("public static void info()");
    }

    @Override
    public String toString() {
        return "[name = " + this.name + ", age = " + this.age + "]";
    }

    // 3. 静态代码块
    static {
        desc = "block-1"; // 静态代码块中可以调用静态属性和方法
        System.out.println("hello, static block-1");
    }

    static {
        desc = "block-2";
        System.out.println("hello, static block-2");
    }

    // 4. 非静态代码块, 可以初始化所有属性（静态和非静态方法、属性）
    {
        age = 11;
        name = "non-static-1";
        System.out.println("hello, non-static block-1");
    }

    {
        age = 22;
        name = "non-static-2";
        System.out.println("hello, non-static block-2");
    }
}
```



7. 静态初始化举例

   ```java
   package BlockTest;
   
   /**
    * @Description: 代码块练习
    * @author : mr.zhi(zhilx1997@sina.com)
    * @version: v1.1
    * @data: 2022/01/02
    * @summary: 代码块执行：由父及子，静态先行
    */
   
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
   ```

   

## 8. 关键字：final

final : 最终的

### 8.1 final 可以用来修饰的结构

类、方法、变量

### 8.2 final 用来修饰一个类

- 用final修饰的类，不可以被继承，比如，String类、System类、StringBuffer类

- ```java
  final class FinalA {
  
  }
  
  class B extends FinalA {} // error，final修饰的类不能被继承
  ```

### 8.3 final 用来修饰方法

- 用final修饰方法，表示方法不可以被重写,  比如Object中的getClass()

- ```java
  class AA {
  	public final void show() {}
  }
  
  class BB extends AA {
  	public void show() {};	// error，被final修饰的方法不可以被重写
  }
  ```

  

### 8.4 final 用来修饰变量（类似于C++中的const）

- 此时的 “变量” 就称为一个常量，不可以再被改变

- final修饰属性：
  - 可以考虑赋值的位置有：显示初始化、在代码块中赋值（初始化）、在构造器中初始化、
  - **note：如果在构造器中赋值，则需要在定义的所有构造器中初始化，否则会报错**
  - 不可以通过“类名.属性" 或 ”类名.方法“ 来初始化，因为当类对象创建的时候，类中的属性和方法就已经被创建了

- final修饰局部变量：
  - final修饰形参时，不可以被修改（类似于C++中的const）



### 8.5 static final ：可以用来修饰属性、方法

- static final 修饰属性：表示全局常量
- static final 修饰方法：表示一个不可被重写的方法，直接可以通过类名调用

### 8.6 如果final修饰类，则类中的属性仍可被修改

```java
/**
 * @Description: final 关键字（类似于C++中的const关键字）
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/03
 * @summary: final : 最终的
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
```





## 9. 抽象类和抽象方法

随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则一般，更通用。类的设计应该包装父类和子类能够共享特征。有时**将一个父类设计得更加抽象，以至于它没有具体的实例，这样的类叫做抽象类**。

### 9.1 abstract 关键字的使用

1. abstract ： 抽象的

2. abstract 可以用来修饰的结构：类、方法

3. abstract 修饰类：抽象类 

   - 此类不能实例化 `abstract class Person {}``

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

/**
 * @Description: 创建抽象类的匿名子类对象
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/05
 */
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("*** 1 - 非抽象类的匿名对象   ******");
        new Student().eat(); // 非抽象类的匿名对象

        System.out.println("*** 3 - 非匿名的类非匿名的对象******");
        Student s = new Student();
        method(s); // 非匿名的类匿名的对象

        System.out.println("*** 4 - 非匿名的类匿名的对象  ******");
        method(new Student());

        System.out.println("*** 5 - 抽象类的匿名子类对象  ******");
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("new Person() will eat food!");
            }

            @Override
            public void breath() {
                System.out.println("new Person() will breath");
            }
        };

        method(p);

        System.out.println("*** 6 - 匿名子类的匿名子类对象 ******");
        method(new Person() {
            @Override
            public void eat() {
                System.out.println("匿名子类的匿名子类对象 will eat food!");
            }

            @Override
            public void breath() {
                System.out.println("匿名子类的匿名子类对象 will breath");
            }
        });
    }

    public static void method(Person p) {
        p.eat();
        p.breath();
    }
}

```



## 10. 模板方法的设计模式和应用场景

### 10.1 多态的应用：模板方法设计模式（TemplateMethod）

抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子总体上会保留抽象类的行为模式。

**解决的问题：**

- 当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
- 换句话说，在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，此时可以将易变部分抽象出来，供不同的子类实现。这就是一种模板模式。

### 10.2 应用场景

模板方法设计模式是编程中经常用得到的模式。各个框架、类库中都有他的影子，比如：

- 数据库访问的封装
- Junit单元测试
- JavaWeb的Servlet中关于doGet/doPost方法调用
- Hibernate中模板程序
- Spriing 中 JDBCTemlate、HibernateTemplate等

### 10.3 案例

编写工资系统、实现不同类型员工（多态）的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。

实验说明：

1. 定义一个Employee类，该类包含：

   - private 成员变量：name, number, birthday, 其中birthday为MyDate类的对象；
   - abstract方法earnings();
   - toString() 方法输出对象的name,number,birthday。

2. MyDate 类包含：

   - private 成员变量，year，month，day；
   - toDateString() 返回日期对应的字符串：xxxx年xx月xx日

3. 定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。该类包括：

   - private成员变量monthlySalary;
   - 实现父类的抽象方法earnings()，该方法返回monthlySalary值；
   - toStriing() 方法输出员工类型信息及员工的name，number，birthday。

4. 参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：

   - private成员变量wage和hour；
   - 实现父类的抽象方法earnings()，该方法返回wage*hour值；
   - toString()方法输出员工类型信息及员工的name, number, birthday。

5. 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存各类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类型name, number, birthday，以及该对象生日。当键盘输入本月月份时，如果本月是某个Employee对象的生日，还要输出增加工资信息。

6. 提示：

   ```java
   // 定义People类型的数组People c1[] = new People[10];
   // 数组元素赋值
   c1[0] = new People("John", "0001", 20);
   c1[1] = new People("Bob", "0002", 19);
   // 若People有两个子类Student和Officer，则数组元素赋值时，可以使父类类型的数组指向子类。
   c1[0] = new People("John", "0002", 20, 85.0);
   c1[1] = new People("Bob", "0002", 19, 90.5);
   ```

   

## 11. 接口（interface）

- 一方面，有时必须从几个类中派生出一个子类，继承它们所有的属性和方法。但是，Java不支持多继承。有了接口，就可以得到多重继承的效果。
- 另一方面，有时必须从几个类中抽取出一些共同的行为特征，而它们之间有没有 is - a 的关系，仅仅是具有相同的行为特征而已。例如：鼠标、键盘、打印机、扫描仪、摄像头、充电器、MP3、手机、数码相机、移动硬盘等都支持USB接口。
- 接口就是规范，定义的是一组规则，体现了现实世界中“如果你是/要。。。则必须能。。。”的思想。**继承是一个“是不是”的关系，而接口实现则是“能不能”的关系。**
- 接口的本质是契约，标准，规范，就像我们的法律一样。制定好后大家都要遵守。

 

### 1. 抽象类（复习）

随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则更一般，更通用。类的设计应该保证父类和子类能够共享特征。有时将一个父类设计得非常抽象，以至于它没有具体的实例，这样的类叫做**抽象类**。

![image-20220107214812094](D:\Program Files (x86)\JavaProject\Java知识点2 - 面对对象下.assets\image-20220107214812094.png)



### 2. 接口

其中篮球运动员和跨栏运动员都属于运动员的子类；大学生和中学生都属于学生的子类。但是由于单继承的关系，跨栏运动员无法和大学生同时再继承于学习的类（学习也不该称为类，应该为一个技能）。因此为了弥补该缺陷，提出了接口。

<img src="D:\Program Files (x86)\JavaProject\Java知识点2 - 面对对象下.assets\image-20220107214851279.png" alt="image-20220107214851279" style="zoom:67%;" />

<img src="D:\Program Files (x86)\JavaProject\Java知识点2 - 面对对象下.assets\image-20220107214236601.png" alt="image-20220107214236601" style="zoom:67%;" />

### 3.  接口的使用

1. 接口使用 interface 来定义

2. Java中，接口和类是并列的两个结构

3. 如何定义接口 ：定义接口中的成员

   1. JDK7 及以前：只能定义全局变量和抽象方法
      - 全局常量：public static final 的，但是书写时，可以省略不写。
      - 抽象方法：public abstract 的，但是书写时，可以省略不写。

   2. JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）

4. 接口中不能定义构造器！！意味着接口不可以实例化。

5. **Java开发中，接口通过让类去实现（implements）的方式来实现**

   - **如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化**
   - **如果实现的类中没有覆盖接口中的所有抽象方法，则此实现类仍为一个抽象类。**

6. Java类可以实现多个接口 ---> 弥补了Java单继承性的局限性

   格式：

   ```java
   class BB extends AA implements CC, DD, EE,... {
   	// 代码
   }
   
   class Bullet extends Object implements Flyable, Attackable {
       @Override
       public void fly() {
           System.err.println("Plane can be fly");
       }
   
       @Override
       public void stop() {
           System.err.println("The plane will stop when the plane runs out of fuel");
       }
       
       @Override
       public void attack() {
           System.out.println("Bullet can be used to attack people");
       }
   }
   ```

7. **接口和接口之间可以继承，也可以多继承**

   ```Java
   interface AA {
   	void method1();
   }
   
   interface BB {
   	void method2();
   }
   
   interface CC extends BB, CC {
   	// 此时CC接口具有BB中的method1和CC中的method2
   }
   ```

8. 接口的具体使用，可以体现多态性

9. **接口：实际上可以看做是一种规范。**

10. **开发中，体会面向接口编程。**

11. **面试题：抽象类和接口有哪些异同？**

    相同点：都不可以实例化对象

```java
/**
 * 6. 接口的具体使用，可以体现多态性
 * 7. **接口：实际上可以看做是一种规范。**
 */
public class USBTest {
    public static void main(String[] args) {
        // 1. 创建了非匿名实现类的非匿名对象
        Flash flash = new Flash();
        Computer.transferData(flash);
        System.err.println("***************************");

        // 2. 创建了非匿名实现类的匿名对象
        Computer.transferData(new Printer());
        System.err.println("***************************");

        // 3. 创建了匿名实现类的匿名对象
        Computer.transferData(new USB() {
            @Override
            public void start() {
                System.err.println("鼠标开始工作");
            }

            @Override
            public void stop() {
                System.err.println("鼠标停止工作");
            }
        });
    }
}

class Computer {
    public static void transferData(USB usb) {
        usb.start();
        System.err.println("开始传输数据");
        usb.stop();
    }
}

// 1. 定义USB接口，其中定义最大、最小的传输速率，尺寸等等
interface USB {
    String name = "USB";

    void start();

    void stop();
}

// 1.1 创建U盘类
class Flash implements USB {
    String name = "Flash";

    @Override
    public void start() {
        System.err.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.err.println("U盘停止工作");
    }
}

// 1.2 创建打印机类
class Printer implements USB {
    String name = "Printer";

    @Override
    public void start() {
        System.err.println("打印机开始工作");

    }

    @Override
    public void stop() {
        System.err.println("打印机停止工作");

    }

}
```



### 4.  接口重点

1. 定义Java类的语法格式：**先写extends，后写implements**

   `class SubClass extends SuperClass Implements InterfaceAa {}`

2. 一个类可以实现多个接口，接口也可以继承其他接口。

3. 实现接口的类中必须提供接口中所有方法的具体实现内容，才可实例化。否则，仍为抽象类

4. 接口的主要用途就是被实现类实现（**面向接口编程**）

5. 与继承关系类似，接口与实现类之间存在多态性

6. 接口和类是并列关系，或者可以理解为一种特殊的类。从本质上讲，接口是一种特殊的抽象类，这种抽象类中**只包含常量和方法的定义（JDK7.0及之前）**，而没有变量和方法的实现。



### 5. 接口的应用

#### 5.1 代理模式（Proxy）

代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。

<img src="D:\Program Files (x86)\JavaProject\Java知识点2 - 面对对象下.assets\image-20220111101304389.png" alt="image-20220111101304389" style="zoom: 67%;" />

**ProxyObject为代理类，ObjectImpl为被代理类**。

#### 5.2 代理模式的应用场景和分类

1. 应用场景

   - **安全代理**：屏蔽对真是角色的直接访问

   - **远程代理**：通过代理类处理远程方法调用（RMI）

   - **延迟加载**：先加载轻量级的代理对象，真正需要再加载真是对象。

     比如要开发一个大文档查看软件，其中包括大的图片，有可能一个图片有100MB，在打开文档时，不可能将所有的图片都显示出来，这样就可以使用代理模式，当需要查看图片时，用Proxy来进行大图片的打开。

2. 分类

   - **静态代理**(静态定义代理类)：
   - **动态代理**(动态生成代理类)：
     - JDK自带的动态代理，需要反射等知识。



#### 5.3 工厂模式（接口的另一个应用）

工厂模式：**实现了创建者与调用者的分离，即将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。**

**其实设计模式和面向对象设计原则都是为了是的开发项目更加容易扩展和维护，解决方式就是一个“分工”。**

社会的发展也是这样，分工越来越细。

##### 1. 面向对象的设计原则

##### 2. 工厂模式的分类：

- **无工厂模式**：

- **简单工厂模式**：用来生产同一等级结构中的任意产品。（对于增加新的产品，需要修改已有代码）

  

  <img src="D:\Program Files (x86)\JavaProject\Java知识点2 - 面对对象下.assets\image-20220111112355005.png" alt="image-20220111112355005" style="zoom:67%;" />

  调用者只要知道他要什么，从哪里拿，如何创建。

  分工：多出了原理个专门生产Car的实现类对象的工厂类。**把调用者与创建者分离。**

  **小结**：简单工厂模式也叫静态工厂模式，就是工厂类一般是使用静态方法，通过接收参数的不同来返回不同的实例对象。

  **缺点**：**对于增加新的产品，不修改代码的话，是无法扩展的。违反了开闭原则。**

- **工厂方法模式**：用来生产同一等级结构中的固定产品。（支持增加任意产品）

  - 为了避免简单工厂模式的缺点，不完全满足OCP（对扩展开放，对修改关闭）。

  - 工厂方法模式和简单工厂模式最大的不同在于，**简单工厂模式只有一个（对于一个项目或者一个独立的模块而言）工厂类，而工厂方法模式有一组实现了相同接口的工厂类**。这样在简单工厂模式里几种在工厂方法上的压力可以有工厂方法模式里不同的工厂子类来分担。

  - **总结**：简单工厂模式与工厂方法模式真正的避免了代码的改动了吗？没有

  - 在简单工厂模式中，新产品的加入要修改工厂角色中的判断语句；而工厂方法模式中，要么将判断逻辑留在抽象工厂角色中，要么在客户程序中将具体的工厂角色写死（就像下面的例子一样）。而且产品对象创建条件的改变必然会引起工厂角色的修改。

  - 面对这种情况，Java的反射机制与配置文件的巧妙结合突破了限制——这在Spring中完美的体现了出来。

- **抽象工厂模式**：用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族）

  - **抽象工厂模式和工厂方法模式的区别就在于需要创建对象的复杂程度上**。而且抽象工厂模式是三个中最为抽象、最具一般性的。
  - 抽象工厂模式的用意为：给客户端提供一个接口，可以创建多个产品族中的产品对象。
  - 而且使用抽象工厂模式还需要满足以下条件：
    - 系统中有多个产品族，而系统一次只可能消费其中一族产品。
    - 同属于同一个产品族的产品以其使用。

GOF在《设计模式》一书中将工厂模式分为两类：工厂方法模式（Factory Method）与抽象工厂模式（Abstract Factory）。将简单工厂模式（Simple Factory）看为工厂方法模式的一种特例，两者归为一类。

**核心本质**：实例化对象，用工厂方法替代new操作。

将选择实现类、创建对象统一管理和控制。从而将调用者跟我妈的实现类解耦。

##### 3. 工厂模式的测试：

- 无工厂模式

  ```java
  package InterfaceTest.FactoryTest;
  
  /**
   * @Description: 工厂模式测试 - 1.无工厂模式
   * @author : mr.zhi(zhilx1997@sina.com)
   * @version: v1.1
   * @data: 2022/01/11 11:00
   * @node: 无工厂模式测试
   */
  public class NoFactoryTest {
      public static void main(String[] args) {
          Audi audi = new Audi();
          audi.run();
          System.err.println("**************************");
  
          BYD byd = new BYD();
          byd.run();
      }
  }
  
  interface car {
      public void run();
  }
  
  // 1. audi
  class Audi implements car {
      @Override
      public void run() {
          System.err.println("奥迪车在跑");
      }
  }
  
  // 2. BYD
  class BYD implements car {
      @Override
      public void run() {
          System.err.println("比亚迪车在跑");
      }
  }
  
  ```

- 简单工厂模式

  ```java
  package InterfaceTest.FactoryTest.SimpleFactory;
  
  /** SimpleFactoryTest.java
   * @Description: 工厂模式测试 - 2.简单工厂模式
   * @author : mr.zhi(zhilx1997@sina.com)
   * @version: v1.1
   * @data: 2022/01/11 11:00
   * @node: 简单工厂模式测试
   */
  public class SimpleFactoryTest {
      public static void main(String[] args) {
          Car byd = CarFactory.getCar("BYD");
          byd.run();
  
          Car audi = CarFactory.getCar("Audi");
          audi.run();
      }
  }
  
  // 3. 简单工厂模式
  class CarFactory {
      // method1:
      public static Car getCar(String name) {
          if (name.equals("Audi")) {
              return new Audi();
          } else if (name.equals("BYD")) {
              return new BYD();
          } else {
              return null;
          }
      }
  
      // method2:
      public static Car getAudi() {
          return new Audi();
      }
  
      public static Car getBYD() {
          return new BYD();
      }
  }
  ```

  ```java
  package InterfaceTest.FactoryTest.SimpleFactory;
  
  /** Car.java
   * @Description: 工厂模式测试 - 2.简单工厂模式中Car接口的实现
   * @author : mr.zhi(zhilx1997@sina.com)
   * @version: v1.1
   * @data: 2022/01/11 11:00
   * @node: 简单工厂模式测试
   */
  // Car接口的实现
  interface Car {
      public void run();
  }
  
  // 1. audi
  class Audi implements Car {
      @Override
      public void run() {
          System.err.println("奥迪车在跑");
      }
  }
  
  // 2. BYD
  class BYD implements Car {
      @Override
      public void run() {
          System.err.println("比亚迪车在跑");
      }
  }
  
  ```

- 工厂模式

  ```java
  package InterfaceTest.FactoryTest.Factory;
  
  /** FactoryTest.java
   * @Description: 工厂模式测试 - 2.工厂模式
   * @author : mr.zhi(zhilx1997@sina.com)
   * @version: v1.1
   * @data: 2022/01/11 11:30
   * @node: 工厂模式测试
   */
  
  public class FactoryTest {
      public static void main(String[] args) {
          Car a = new AudiFactory().getCar();
          a.run();
          System.err.println("*******************");
  
          Car b = new BYDFactory().getCar();
          b.run();
      }
  }
  
  package InterfaceTest.FactoryTest.Factory;
  
  /**Car.java
   * @Description: 工厂模式测试 - 2.简单工厂模式中Car接口的实现
   * @author : mr.zhi(zhilx1997@sina.com)
   * @version: v1.1
   * @data: 2022/01/11 11:00
   * @node: 简单工厂模式测试
   */
  // Car接口的实现
  interface Car {
      public void run();
  }
  
  // 1. audi
  class Audi implements Car {
      @Override
      public void run() {
          System.err.println("奥迪车在跑");
      }
  }
  
  // 2. BYD
  class BYD implements Car {
      @Override
      public void run() {
          System.err.println("比亚迪车在跑");
      }
  }
  
  // 3. 构造接口
  interface Factory {
      Car getCar();
  }
  
  // 4. 构造Audi工厂类 和 ByD工厂类
  class AudiFactory implements Factory {
      @Override
      public Car getCar() {
          return new Audi();
      }
  }
  
  class BYDFactory implements Factory {
      @Override
      public Car getCar() {
          return new BYD();
      }
  }
  ```

  

## 12. 问题

1. 如果接口A和类B中存在同名变量x，则class C extends B implements A {} 中的x为那个变量（需要通过super或者接口名来确定调用哪一个）

2. 如果接口中存在同名的方法，则类在实现时，会实现哪一个（如果在implements了多个接口，则实现时会全部实现）

   ```java
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
   
   ```

   ```java
   package InterfaceTest;
   
   /**
    * @Description: 接口中的问题
    * @author : mr.zhi(zhilx1997@sina.com)
    * @version: v1.1
    * @data: 2022/01/12 12:35
    * @node: 2 - 接口中存在同名的方法
    */
   public class Question2 {
       public static void main(String[] args) {
           new Ball("footable").play(); // 输出PingPang
       }
   }
   
   interface Playable {
       void play();
   }
   
   interface Bounceable {
       void play();
   }
   
   interface Rollable extends Playable, Bounceable {
       // Ball ball 等价于 public static final Ball ball, 因为ball为final修饰的，因此不可以修改
       Ball ball = new Ball("PingPang");
   }
   
   class Ball implements Rollable {
       private String name;
   
       public Ball() {
   
       }
   
       public Ball(String name) {
           this.name = name;
       }
   
       public String getName() {
           return name;
       }
   
       @Override
       // 此时play()函数相当于对Playable和Bounceable中的play()方法进行了重写（因为同名）
       public void play() {
           // ball = new Ball("Footable"); error, 因为ball在Rollable中定义的，为final修饰的，不可以更改
           System.out.println(ball.getName());
       }
   }
   ```

   

## 13.  JDK8及以后的新特性

- JDK7 及以前：只能定义全局变量和抽象方法
  - 全局常量：public static final 的，但是书写时，可以省略不写。
  - 抽象方法：public abstract 的，但是书写时，可以省略不写。

- JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法

Java8中，可以为接口添加静态方法和默认方法。从技术角度来说，这是完全合法的，只是它看起来违反了接口作为一个抽象定义的理念。

- 静态方法：使用`static`关键字修饰。**可以通过接口直接调用静态方法**，并执行其方法体。我们经常在相互一起使用的类中使用静态方法。我们可以在标准库中找到像Collection/Collections或者Path/Paths这样成对的接口和类。

- 默认方法：默认方法使用`default`关键字修饰。可以通过实现类对象来调用。我们在已有的接口中提供新方法的同时，还保持了与就版本代码的兼容性。比如：java8 API中对Collection、List、Comparator等接口提供了丰富的默认方法。



### 知识点：

1. 接口中定义的静态方法，只能通过接口来调用

2. 通过实现类的对象，可以调用接口中的默认方法

   如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写的方法

3. **如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的而方法，那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法（与变量不同，变量的调用必须声明调用的是接口中的还是类中的）。 ---> 类优先原则**

4. **如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法的情况下，会报错 ---> 接口冲突。**（如果该实现类的父类中也有该方法则不会报错）

   这就需要我们必须再实现类中出重写此方法。

5. 如何在子类（或实现类）的方法中调用父类、接口中被重写的方法。

   ```java
   public void myMethod() {
   	method3(); // 调用自己定义的重写的方法method3()
   	super.method3(); // 调用父类中的method3()
   	
   	// 调用接口中的默认方法
   	CompareA.super.method3();
   	CompareB.super.method4();
   }
   ```

   

```java
package InterfaceTest.InterfaceJDK8;

import javax.swing.ComboBoxEditor;

/**
 * @Description: JDK8及其以后的新特性Main函数测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 12:35
 * @node:
 *        - JDK7 及以前：只能定义全局变量和抽象方法
 *        -- 全局常量：public static final 的，但是书写时，可以省略不写。
 *        -- 抽象方法：public abstract 的，但是书写时，可以省略不写。
 * 
 *        - JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 */
public class SubClassTest {
    public static void main(String[] args) {
        SubClass1 sc = new SubClass1();
        // 知识点1 - 接口中定义的静态方法，只能通过接口来调用
        // sc.method1(); // error, 报没有定义method1()的异常
        CompareA.method1(); // right，静态方法只能通过接口来调用

        // 知识点2 - 通过实现类的对象，可以调用接口中的默认方法
        sc.method2(); // right

        // 知识点3 - 如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的而方法，
        // 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法（与变量不同，变量的调用必须声明调用的是接口中的还是类中的）。
        // ---> 类优先原则
        sc.method3(); // right

        System.out.println("**********************");
        sc.myMethod();
    }
}

class SubClass1 extends SuperClass implements CompareA, CompareB {
    public void method2() {
        System.out.println("SubClass : public void method2() - 重写接口中的默认方法method2");
    }

    @Override
    public void method3() {
        System.out.println("SubCLass1 - method3()");
    }

    public void myMethod() {
        // 1.1 调用自己重写的method3()
        method3();
        // 1.2 调用父类中的method3()
        super.method3();
        // 1.3 调用接口CompareA和CompareB中的method3()
        CompareA.super.method3();
        CompareB.super.method3();
    }
}

// 知识点4 -如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
// 那么在实现类没有重写此方法的情况下，会报错 ---> 接口冲突。
// （如果该实现类的父类中也有该方法则不会报错）
// class SubClass2 implements CompareA, CompareB {
// public void method2() {
// System.out.println("SubClass : public void method2() - 重写接口中的默认方法method2");
// }
// }


package InterfaceTest.InterfaceJDK8;

/**
 * @Description: JDK8及其以后的新特性
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 12:35
 * @node:
 *        - JDK7 及以前：只能定义全局变量和抽象方法
 *        -- 全局常量：public static final 的，但是书写时，可以省略不写。
 *        -- 抽象方法：public abstract 的，但是书写时，可以省略不写。
 * 
 *        - JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 */
public interface CompareA {
    int k = 10;

    // 1. 静态方法
    public static void method1() {
        System.out.println("CompareA : public static method1(){} - 接口中的静态方法");
    }

    // 2. 默认方法
    public default void method2() {
        System.out.println("CompareA : public default method2(){} - 接口中的默认方法");
    }

    // 3. 默认方法
    default void method3() {
        System.out.println("CompareA : default method3(){} - 接口中的默认方法");
    }
}

package InterfaceTest.InterfaceJDK8;

public interface CompareB {
    default void method3() {
        System.out.println("CompareB : default void method3();");
    }
}


```



## 14. 类的内部成员之五 - 内部类

- 当一个事物的内部，还有一个部分需要一个完整的结构进行描述，而这个内部的完整的结构又只为外部事物提供服务，那么整个内部的完整结构最好使用内部类。

- 在Java中，允许一个类的定义位于另一个类的内部，**前者称为内部类，后者称为外部类**。

- Inner class 一般用在定义它的类或语句块之内，在外部引用它时必须给出完成的名称。

  `Inner class的名字不能与包含它的外部类类名相同`

- **分类**：

  - 成员内部类：static成员内部类和非static成员内部类
  - 局部内部类：（不谈修饰符）、匿名内部类、方法、代码块和构造器内

### 1. 成员内部类

1. 一方面，作为外部类的成员：
   - 可以调用外部类的结构
   - 可以被static修饰
   - 可以被4中不同的权限修饰符修饰
2. 另一方面，作为一个类：
   - 类内可以定义属性、方法、构造器等
   - 可以用final修饰，表示此类不可以被继承（如果没有被final修饰，则可以被继承）
   - 可以被abstract修饰，此时就不可以实例化对象

3. 总结：**关注如下的三个问题**：

   1. 如何实例化成员内部类的对象

   2. 如何在成员内部类中区分调用外部类的结构

   3. 开发中，局部内部类的使用

      1. 直接在方法中定义局部类并使用
      2. 返回一个实现了xxx接口的类的对象

      ```java
      public class InnerClassTest2 {
          // 1. 内部类的调用，开发中很少使用
          public void method() {
              class AA {
      
              }
          }
      
          // 2. 返回一个实现了xxx接口的类的对象
          public Comparable getCioComparable() {
              // 实现一个创建Comparable接口的类：局部内部类
              // 方式1：创建内部类
              // class MyComparable implements Comparable {
      
              // @Override
              // public int compareTo(Object o) {
              // // TODO Auto-generated method stub
              // return 0;
              // }
              // }
      
              // return new MyComparable();
      
              // 方式2：创建内部内部类
              return new Comparable() {
                  @Override
                  public int compareTo(Object o) {
                      // TODO Auto-generated method stub
                      return 0;
                  }
              };
          }
      }
      ```

      

