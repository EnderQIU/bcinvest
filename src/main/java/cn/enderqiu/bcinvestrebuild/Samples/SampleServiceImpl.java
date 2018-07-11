package cn.enderqiu.bcinvestrebuild.Samples;

import cn.enderqiu.bcinvestrebuild.service.impl.BaseImpl;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl extends BaseImpl implements SampleService {
    @Override
    public String sampleSamplePOST(String source) {
        //进行数据库操作
        mapper.SELECT("数据库语句");
        return null;
    }
}
