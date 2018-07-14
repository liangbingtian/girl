package com.liang.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * liangbingtian
 * 2018/7/14 上午10:11
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "girl.do",method = RequestMethod.GET)
    public String say(){

        return girlProperties.getCupSize();
    }
}
