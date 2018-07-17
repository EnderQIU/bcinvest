package cn.enderqiu.bcinvestrebuild.controller;

import cn.enderqiu.bcinvestrebuild.service.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/miner")
@Api("挖矿地址")
public class LinkController {
    @Autowired
    private LinkService service;

//    @RequestMapping(value = "/reciver", method = RequestMethod.POST)
//    @ApiImplicitParams({
//            @ApiImplicitParam(
//                    paramType = "query",
//                    name = "block",
//                    required = true,
//                    value = "一个JSON格式的文件，用于封装块",
//                    dataType = "String"
//            )
//    })
//    void link(String blockJSON) {
//    }
}
