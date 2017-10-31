package top.blentle.prairie.core;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/31 0031
 * @description :
 * @since : 1.0
 */
public class DemoConsumer {
    public static void main(String[] args) {
        DemoService demoService = (DemoService) EndpointServer.refer(DemoService.class, "127.0.0.1", 1100);
        String a = demoService.hello("renhuan", 29);
        System.err.println(a);
    }
}
