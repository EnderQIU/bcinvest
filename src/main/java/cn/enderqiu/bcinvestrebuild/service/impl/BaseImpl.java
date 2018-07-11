package cn.enderqiu.bcinvestrebuild.service.impl;

import cn.enderqiu.bcinvestrebuild.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseImpl {
    @Autowired
    protected Mapper mapper;
}
