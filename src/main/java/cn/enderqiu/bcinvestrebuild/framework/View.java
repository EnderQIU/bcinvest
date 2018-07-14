package cn.enderqiu.bcinvestrebuild.framework;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class View {

    @Autowired
    protected DSLContext dsl;
}
