package top.blentle.prairie.core.util;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/11
 * @description :
 * @since : 1.0
 */
public class Assert {

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

}
