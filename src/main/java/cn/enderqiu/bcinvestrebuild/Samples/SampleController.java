package cn.enderqiu.bcinvestrebuild.Samples;

import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
/* 这里是指 通过这个类处理的所有请求都会有的请求URL的开头部分
 * 标注/sample意思是这个类专门用来处理/sample/*类型的请求，如/sample/test/ -POST这样的请求
 */
@Api("例子")
@RequiredPermissions("访问权限")
/* 权限分三种，company, bank, authority，其中可以写字符串列表
 * 例如：（只允许银行和权威机构访问）
 *      @RequiredPermissions("bank, authority")
 */
public class SampleController extends BaseController {
    @Autowired //记得标注，否则service不会有值
    private SampleService service; //SampleService is an interface


    @RequestMapping(value = "/sample", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "<数据的来源>",
                    /* 来源分为form, header, query
                     * 分别对应 表单，请求头， 请求体
                     */
                    name = "source", //和参数列表的参数名对应
                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
                    value = "<对这个属性的描述，可以是中文>",
                    dataType = "<类型名，一般是String>"
            )
    })
    String sampleSamplePOST(String source) {
        //尽量直接传递，可以做一点包装，这里体现了Controller和Service的分离
        //Controller的工作仅仅是路由，实际工作由Service完成
        return service.sampleSamplePOST(source);
    }
}
