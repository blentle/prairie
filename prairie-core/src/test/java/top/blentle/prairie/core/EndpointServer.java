package top.blentle.prairie.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/30 0030
 * @description :
 * @since : 1.0
 */
public class EndpointServer {
    /**
     * expose service
     *
     * @param service
     * @param port
     */
    public static void expose(Object service, int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket socket = ss.accept();
            new Thread(() -> {
                ObjectInputStream is = null;
                ObjectOutputStream os = null;
                try {
                    is = new ObjectInputStream(socket.getInputStream());
                    os = new ObjectOutputStream(socket.getOutputStream());
                    String methodName = is.readUTF();
                    Class[] parameterTypes = (Class[]) is.readObject();
                    Object[] arguments = (Object[]) is.readObject();
                    Method method = service.getClass().getMethod(methodName, parameterTypes);
                    Object result = method.invoke(service, arguments);
                    os.writeObject(result);
                } catch (Exception e) {
                    System.err.println("get client socket error.." + e);
                    //todo:
                } finally {

                    try {
                        is.close();
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * @param <C>
     * @param in   service interface
     * @param host  invoke every method of service interface
     * @param port
     * @return
     */
    public static <C> Object refer(final Class<C> in, String host, int port) {
        // proxy service ....
        return Proxy.newProxyInstance(in.getClassLoader(), new Class<?>[]{in}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket client = new Socket(host, port);
                ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
                os.writeUTF(method.getName());
                os.writeObject(method.getParameterTypes());
                os.writeObject(args);
                ObjectInputStream input = new ObjectInputStream(client.getInputStream());
                Object result = input.readObject();
                return result;
            }
        });
    }


}
