package top.blentle.prairie.core;

import java.io.IOException;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/31 0031
 * @description :
 * @since : 1.0
 */
public class DemoProvider {
    public static void main(String[] args) throws IOException {
        DemoService service = new DemoServiceImpl();
        EndpointServer.expose(service, 1100);
    }
}
