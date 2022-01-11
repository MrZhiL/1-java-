package InterfaceTest;

/**
 * @Description: Interface 中代理模式的测试 - 使用network进行测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/11 10:20
 * @node: 代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。
 *        **ProxyObject为代理类，ObjectImpl为被代理类**。
 */
public class ProxyTest {
    public static void main(String[] args) {
        Network net = new Server();

        ProxyServer proxyServer = new ProxyServer(net);
        proxyServer.browse();
    }
}

interface Network {
    public void browse();
}

// 1. 被代理模式
class Server implements Network {
    @Override
    public void browse() {
        System.err.println("真实网络服务器的访问");
    }
}

// 2. 代理模式
class ProxyServer implements Network {

    private Network net;

    public ProxyServer(Network work) {
        this.net = work;
    }

    public void check() {
        System.err.println("联网之前需要先进行检查");
    }

    @Override
    public void browse() {
        check();
        net.browse();
    }
}