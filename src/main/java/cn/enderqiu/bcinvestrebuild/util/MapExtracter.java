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
            String r = s.substring(0, 1).toLowerCase() + s.substring(1, s.length());
            PropertyDescriptor descriptor = new PropertyDescriptor(s, t.getClass());
            Method setter = descriptor.getWriteMethod();
//            if (map.get(s) instanceof Integer)
//                setter.invoke(t, (int)map.get(s));
//            else
//                setter.invoke(t, map.get(s));
            setter.invoke(t, map.get(s));
//            setter.invoke((setter.getParameters()[0].getClass())map.get(s));
        }
    }
}
