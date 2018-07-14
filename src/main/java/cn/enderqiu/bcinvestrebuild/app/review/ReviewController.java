package cn.enderqiu.bcinvestrebuild.app.review;

import cn.enderqiu.bcinvestrebuild.app.review.response.ReviewDataResponse;
import cn.enderqiu.bcinvestrebuild.app.review.serializer.ReviewDataFormSerializer;
import cn.enderqiu.bcinvestrebuild.framework.Controller;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("企业信息认证业务")
@RequestMapping("/review")
@RestController
public class ReviewController extends Controller {

    @Autowired
    private ReviewView reviewView;

    @RequiredPermissions("company")
    @ApiOperation("企业用户提交用户信息")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "", value = ""),
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "", value = ""),
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "", value = ""),
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "", value = ""),
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "", value = ""),
    })
    public ReviewDataResponse uploadReviewData(ReviewDataFormSerializer serializer){
        return reviewView.uploadReviewData(request.getUserRecord(), serializer);
    }

    @RequiredPermissions("company, authority, bank")
    @ApiOperation(value = "查询用户信息审核情况", notes = "银行、机构调用此接口返回所有审查状况，企业用户调用时只会返回自己的审查状况，无需传参")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiImplicitParams({
    })
    public List<ReviewDataResponse> getReviewData(){
        return reviewView.getReviewData(request.getUserRecord());
    }

    @RequiredPermissions("authority")
    @ApiOperation(value = "设置企业审核资料状态", notes = "")
    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "companyId", value = "所审核的用户的ID"),
    })
    public ReviewDataResponse setReviewStatus(ReviewDataFormSerializer serializer){
        return  reviewView.setReviewStatus(serializer);
    }
}
