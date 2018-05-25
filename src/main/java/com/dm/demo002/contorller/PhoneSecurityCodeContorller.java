/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PhoneSecurityCodeContorller
 * Author:   DM-admin
 * Date:     2018/5/24 17:03
 * Description: test
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dm.demo002.contorller;

import com.dm.demo002.uitl.PhoneSecurityCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author DM-admin
 * @create 2018/5/24
 * @since 1.0.0
 */
@RestController
public class PhoneSecurityCodeContorller {

    @RequestMapping("/code")
    public Map testController(HttpServletResponse response, String phone) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,String> map=new HashMap<String, String>();

        String code=PhoneSecurityCode.sendNote(phone);
//        String code="123456";
        map.put("str",code);

        System.out.println(phone+":"+code);

        return map;
    }

}