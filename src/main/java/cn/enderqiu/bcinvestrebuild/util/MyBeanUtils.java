package cn.enderqiu.bcinvestrebuild.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyBeanUtils {
    /**
     * 忽略大小写转换bean类型
     *
     * @param obj 转换的源对象
     * @param clz 目标对象
     * @return 转换后的对象
     */
    public static <T> T transferObjectIgnoreCase(Object obj, Class clz) {
        T result = null;
        try {
            if (obj != null && !obj.equals("")) {
                result = (T) clz.newInstance();
                //获取目标类的属性集合
                Map<String, Field> destPropertyMap = new HashMap<>();
                for (Field curField : clz.getDeclaredFields()) {
                    destPropertyMap.put(curField.getName().toLowerCase(), curField);
                }
                //拷贝属性
                for (Field curField : obj.getClass().getDeclaredFields()) {
                    Field targetField = destPropertyMap.get(curField.getName().toLowerCase());
                    if (targetField != null) {
                        targetField.setAccessible(true);
                        curField.setAccessible(true);
                        targetField.set(result, curField.get(obj));
                    }
                }
            }
        } catch (Exception e1) {
            return null;
        }
        return result;
    }
}
