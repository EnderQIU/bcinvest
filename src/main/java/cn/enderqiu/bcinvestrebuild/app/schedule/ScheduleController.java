package cn.enderqiu.bcinvestrebuild.app.schedule;


import cn.enderqiu.bcinvestrebuild.app.schedule.response.ScheduleResultResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleView view;

    @RequestMapping(value = "/credit", method = RequestMethod.GET)
    @ApiOperation("执行检查信用链定时任务")
    public ScheduleResultResponse checkCreditChain(){
        return view.checkCreditChain();
    }

    @RequestMapping(value = "/guaranty", method = RequestMethod.GET)
    @ApiOperation("执行检查抵押物链定时任务")
    public ScheduleResultResponse checkGuarantyChain(){
        return view.checkGuarantyChain();
    }

}
