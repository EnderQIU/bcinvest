package cn.enderqiu.bcinvestrebuild.Samples;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SampleService extends BaseService {
    public SampleVO sampleSamplePOST(String source) {
        //进行数据库操作
        mapper.SELECT("数据库语句");
        return null;
    }
}
