package cn.enderqiu.bcinvestrebuild.samples;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.enderqiu.bcinvestrebuild.util.MapExtracter;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//自己写的应该放到app包自己所属的包中
/* 每个人在app包建一个新的属于自己的包
 * 自己负责的包括Controller, Service, VO都放在这个自己的地方中
 * 分离开发，不需要依赖别人的部分
 */
/* VO可以含有多余的字段名
 * 但是一定要含有和map内列名完全相同的字段和相应的getter, setter
 * 首字母大小写可以随意
 * 否则会报错
 */
@Service
public class SampleService extends BaseService {
    public SampleVO sampleSamplePOST(String source) {
        //进行数据库操作
        List<Map<String, Object>> list = mapper.SELECT("数据库语句");
        Map<String, Object> map = list.get(0);
        SampleVO vo = new SampleVO();
        extract(vo, map);
        return vo;
    }

    public List<SampleVO> sampleReturnList() {
        List<Map<String, Object>> list = mapper.SELECT("一个返回很多个行的语句");

        //对list进行加工，例如如果对前端的返回数据是user_id_token的话就要把token改成这个名字
        //因为下面的填充操作必须要VO的名字和map内的列名完全相同才能返回，否则会报错
        //但是不是说一定要是user_id_token，自己写的时候记得前端返回的名字即可
        //例如：
        changeKeyNameForList(list, "Token", "user_id_token");

        //使用getVOListByResult来获得需要的list，不需要自己创建。
        List<SampleVO> lvo = getVOListByResult(list, SampleVO.class);

        //对lvo进行加工操作

        return lvo;
    }

    //规定一页包含<n>条数据
    public List<SampleVO> samplePages(String paramNeeded, int page) {
        int pageStartIndex = 0;
//        pageStartIndex = <n> * (page - 1);

        //记得必须要有ORDER BY，否则会有可能重复
        //<n>的地方要 去掉双引号 ，这个是数量，不是结束的地方
        List<Map<String, Object>> list = mapper.SELECT(
                "SELECT ... ORDER BY ... LIMIT "+ pageStartIndex + ", " + "<n>");

        //对list进行加工，例如如果对前端的返回数据是user_id_token的话就要把token改成这个名字
        //因为下面的填充操作必须要VO的名字和map内的列名完全相同才能返回，否则会报错

        //使用getVOListByResult来获得需要的list，不需要自己创建。
        List<SampleVO> lvo = getVOListByResult(list, SampleVO.class);

        //对lvo进行加工操作

        return lvo;
    }
}
