package cn.enderqiu.bcinvestrebuild.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class MapExtracter {
    public static <T> void extract(T t, Map<String, Object> map) throws IntrospectionException,
            InvocationTargetException, IllegalAccessException {
        for (String s:map.keySet()) {
            s = s.substring(0, 1).toLowerCase() + s.substring(1, s.length());
            PropertyDescriptor descriptor = new PropertyDescriptor(s, t.getClass());
            Method setter = descriptor.getWriteMethod();
            setter.invoke(map.get(s));
        }
    }
}
