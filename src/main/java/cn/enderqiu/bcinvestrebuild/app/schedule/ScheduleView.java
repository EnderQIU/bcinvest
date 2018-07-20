package cn.enderqiu.bcinvestrebuild.app.schedule;

import cn.enderqiu.bcinvestrebuild.app.schedule.response.ScheduleResultResponse;
import cn.enderqiu.bcinvestrebuild.util.CreditChainUtil;
import cn.enderqiu.bcinvestrebuild.util.GuarantyChainUtil;
import org.springframework.stereotype.Service;

@Service
public class ScheduleView {
    public ScheduleResultResponse checkCreditChain() {
        CreditChainUtil.updateCreditSchedule();
        return new ScheduleResultResponse();
    }

    public ScheduleResultResponse checkGuarantyChain() {
        GuarantyChainUtil.checkStateWhetherUpdate();
        return new ScheduleResultResponse();
    }
}
