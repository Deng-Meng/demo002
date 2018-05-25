/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HelloContorller
 * Author:   DM-admin
 * Date:     2018/5/25 10:05
 * Description: test
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dm.demo002.contorller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author DM-admin
 * @create 2018/5/25
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloContorller {
    @RequestMapping("/helloweb")
    public String hello(ModelMap modelMap){
        //向模板中添加属性
        modelMap.put("hello","helloweb");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}