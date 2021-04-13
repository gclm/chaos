package club.gclmit.chaos.core.utils;

import lombok.experimental.UtilityClass;

/**
 * ArrayUtils工具类
 *
 * @author gclm
 */
@UtilityClass
public class ArrayUtils {

    /**
     * 判断数据是否为空
     *
     * @param array 长度
     * @return 数组对象为null或者长度为 0 时，返回 false
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否不为空
     *
     * @param array 数组
     * @return 数组对象内含有任意对象时返回 true
     * @see ArrayUtils#isEmpty(Object[])
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断一个对象是否是一个数组
     *
     * @param obj 对象
     * @return boolean
     * @author gclm
     */
    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass().isArray();
    }
}