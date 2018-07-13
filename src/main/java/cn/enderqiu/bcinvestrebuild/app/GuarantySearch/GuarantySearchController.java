package cn.enderqiu.bcinvestrebuild.app.GuarantySearch;

/**
 * Created by EvanChoo on 7/13/18.
 */

import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/guarantySearch")
@Api("抵押物查询")
@RequiredPermissions("company")
public class GuarantySearchController extends BaseController {
    @Autowired
    private GuarantySearchService guarantySearchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "form",
                    name = "user_id_token",
                    required = true,
                    value = "用户的标识符",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyType",
                    required = true,
                    value = "抵押物类型, 如果没有就发送null给后台;房产，土地，机器",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyName",
                    required = true,
                    value = "抵押物名称, 如果没有就返回null给后台",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyState",
                    required = true,
                    value = "抵押物状态，如果选择所有状态的抵押物则向后台发送-1",
                    dataType = "int"
            )
    })
    List<GuarantySearchVO> searchGuaranty(String user_id_token, String guarantyType, String guarantyName, int guarantyState) {
        return guarantySearchService.searchGuanranty(user_id_token, guarantyType, guarantyName, guarantyState);
    }
}
