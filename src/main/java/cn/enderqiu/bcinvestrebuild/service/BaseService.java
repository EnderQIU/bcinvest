package cn.enderqiu.bcinvestrebuild.service;

import cn.enderqiu.bcinvestrebuild.mapper.Mapper;
import cn.enderqiu.bcinvestrebuild.util.MapExtracter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BaseService {
    @Autowired
    protected Mapper mapper;

    protected <T> void extract(T t, Map<String, Object> map) {
        try {
            MapExtracter.extract(t, map);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //如果不支持无参构造函数则不能使用
    protected <T> List<T> getVOListByResult(List<Map<String, Object>> from, Class<T> tClass) {
        List<T> list = new ArrayList<>();
        for (Map<String, Object> map:from) {
            T t = null;
            try {
                t = tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            extract(t, map);
            list.add(t);
        }
        return list;
    }

    protected void changeKeyNameForMap(Map<String, Object> map, String oldName, String newName) {
        Object o = map.get(oldName);

        map.remove(oldName);

        map.put(newName, o);
    }

    protected void changeKeyNameForList(List<Map<String, Object>> list, String oldName, String newName) {
        for (Map<String, Object> map:list)
            changeKeyNameForMap(map, oldName, newName);
    }
}
