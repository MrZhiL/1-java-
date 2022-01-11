- #### 工厂模式（接口的另一个应用）

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

    

  

