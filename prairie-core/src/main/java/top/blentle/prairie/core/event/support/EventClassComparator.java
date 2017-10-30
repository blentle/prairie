package top.blentle.prairie.core.event.support;

import java.util.Comparator;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/08/30
 * @description : if a extends b or a implements b  , b > a ;
 * @since : 1.0
 */
public class EventClassComparator implements Comparator<Class> {
    @Override
    @SuppressWarnings("unchecked")
    public int compare(Class a, Class b) {
        if (a == null) {
            if (b == null) {
                return 0;
            } else {
                return -1;
            }
        } else if (b == null) {
            return 1;
        } else if (a == b || a.equals(b)) {
            return 0;
        } else {
            if (a.isAssignableFrom(b)) {
                return 1;
            } else if (b.isAssignableFrom(a)) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
