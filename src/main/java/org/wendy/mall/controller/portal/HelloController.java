package org.wendy.mall.controller.portal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/6/22 11:26
 * @Version 1.0
 */
@Api(tags = "HelloController", description = "测试接口")
@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation(value = "hello测试接口")
    @GetMapping("/world")
    public String helloWorld(){
        return "Hello World";
    }

}
