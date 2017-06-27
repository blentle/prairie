package top.blentle.prairie.core.register;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/6/27 0027
 * @description :
 * @since : 1.0
 */
public class RpcUrl {

    private String protocl;

    private String interfaceName;

    private String methodName;

    private int port;

    public String getProtocl() {
        return protocl;
    }

    public void setProtocl(String protocl) {
        this.protocl = protocl;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
