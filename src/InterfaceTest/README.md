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

10. **面试题：抽象类和接口有哪些异同？**

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

