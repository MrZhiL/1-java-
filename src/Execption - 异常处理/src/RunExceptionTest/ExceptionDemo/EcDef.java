// package RunExceptionTest.ExceptionDemo;

/**
 * @Description: 自定义负数异常
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/16 09:43
 */
public class EcDef extends Exception {
    static final long serialVersionUID = -3387519193124229948L;

    public EcDef() {

    }

    public EcDef(String msg) {
        super(msg);
    }
}
