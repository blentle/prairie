package top.blentle.prairie.core;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/31 0031
 * @description :
 * @since : 1.0
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello(String name, int age) {
        return name + ":" + age + " say hello !";
    }
}
