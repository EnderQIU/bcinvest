package cn.enderqiu.bcinvestrebuild.service;

import cn.enderqiu.bcinvestrebuild.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Autowired
    protected Mapper mapper;
}
