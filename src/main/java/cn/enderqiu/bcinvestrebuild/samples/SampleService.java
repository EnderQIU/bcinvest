package cn.enderqiu.bcinvestrebuild.samples;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//自己写的应该放到app包自己所属的包中
/* 每个人在app包建一个新的属于自己的包
 * 自己负责的包括Controller, Service, VO都放在这个自己的地方中
 * 分离开发，不需要依赖别人的部分
 */
@Service
public class SampleService extends BaseService {
    public SampleVO sampleSamplePOST(String source) {
        //进行数据库操作
        List<Map<String, Object>> list = mapper.SELECT("数据库语句");
        Map<String, Object> map = list.get(0);
        SampleVO vo = new SampleVO();
        vo.setSampleInt((int)map.get("SampleInt"));
        vo.setSampleString((String)map.get("SampleString"));
        return vo;
    }

    public List<SampleVO> sampleReturnList() {
        List<Map<String, Object>> list = mapper.SELECT("一个返回很多个行的语句");
        List<SampleVO> lvo = new ArrayList<>();
        for (Map<String, Object> map:list) {
            SampleVO vo = new SampleVO();
            vo.setSampleInt((int)map.get("SampleInt"));
            vo.setSampleString((String)map.get("SampleString"));
            lvo.add(vo);
        }
        return lvo;
    }

    //规定一页包含<n>条数据
    public List<SampleVO> samplePages(String paramNeeded, int page) {
        int pageStartIndex = 0;
        int pageEndIndex = 0;
//        pageStartIndex = <n> * (page - 1);
//        pageEndIndex = pageStartIndex + <n>;
        List<Map<String, Object>> list = mapper.SELECT(
                "SELECT ... ORDER BY ... LIMIT "+ pageStartIndex + ", " + pageEndIndex);
        List<SampleVO> lvo = new ArrayList<>();
        for (Map<String, Object> map:list) {
            SampleVO vo = new SampleVO();
            vo.setSampleInt((int)map.get("SampleInt"));
            vo.setSampleString((String)map.get("SampleString"));
            lvo.add(vo);
        }
        return lvo;
    }
}
