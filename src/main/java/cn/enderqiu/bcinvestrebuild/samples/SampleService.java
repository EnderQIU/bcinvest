package cn.enderqiu.bcinvestrebuild.samples;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

//自己写的应该放到app包自己所属的包中
/* 每个人在app包建一个新的属于自己的包
 * 自己负责的包括Controller, Service, VO都放在这个自己的地方中
 * 分离开发，不需要依赖别人的部分
 */
@Service
public class SampleService extends BaseService {
    public SampleVO sampleSamplePOST(String source) {
        //进行数据库操作
        mapper.SELECT("数据库语句");
        return null;
    }
}
