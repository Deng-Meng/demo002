/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PhoneSecurityCode
 * Author:   DM-admin
 * Date:     2018/5/24 16:40
 * Description: 短信验证码工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dm.demo002.uitl;

import com.dm.demo002.uitl.random.Code;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈短信验证码工具类〉
 *
 * @author DM-admin
 * @create 2018/5/24
 * @since 1.0.0
 */
public class PhoneSecurityCode {
    public static final String QUERYUESR = "https://api.miaodiyun.com/20150822/query/accountInfo";//查询用户信息

    public static final String SENDNOTE = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//发送短信

    public static final String ACCOUNTSID = "dd85de2ea1a54e73b8852666ebc70213";

    public static final String AUTHKEY = "fd05e770e4614c5c820b84191e97add1";


    public static final String DATEFORMATE = "yyyyMMddHHmmss";


    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMATE);

    /**
     * 查询用户信息
     *
     * @throws IOException*/

    public static void queryUserInfo() throws IOException {


        String timeStamp = timeStampUtil();
        String sigStr = sigNumberCreateUtil(timeStamp);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(QUERYUESR);
        //设置请求头信息
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

        //设置参数相关(表单数据进行设置)
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        NameValuePair account = new BasicNameValuePair("accountSid", ACCOUNTSID);
        NameValuePair timestamp = new BasicNameValuePair("timestamp", timeStamp);
        NameValuePair sig = new BasicNameValuePair("sig", sigStr);
        NameValuePair respDataType = new BasicNameValuePair("respDataType", "JSON");

        list.add(account);
        list.add(timestamp);
        list.add(sig);
        list.add(respDataType);
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list);
        httpPost.setEntity(urlEncodedFormEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        String jsonData = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(jsonData);

    }


    /**
     * 发送短信消息
     *
     * @throws IOException
     */

    public static String sendNote(String phone) throws IOException {

        String time = timeStampUtil();
        String sigStr = sigNumberCreateUtil(time);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求设置相关
        HttpPost httpPost = new HttpPost(SENDNOTE);
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String code = Code.getCodeTest();
        String noteMsg = "【大众科技】您的验证码为"+code+"，请于10分钟内正确输入，如非本人操作，请忽略此短信。";

        NameValuePair accountSid = new BasicNameValuePair("accountSid", ACCOUNTSID);
        //注意:此时的短信信息格式需要注意:需要有对应的模板信息进行操作(参数设置)
        NameValuePair smsContent = new BasicNameValuePair("smsContent", noteMsg);
        NameValuePair to = new BasicNameValuePair("to", phone);
        NameValuePair timestamp = new BasicNameValuePair("timestamp", time);
        NameValuePair sig = new BasicNameValuePair("sig", sigStr);
        NameValuePair respDataType = new BasicNameValuePair("respDataType", "JSON");
        params.add(accountSid);
        params.add(smsContent);
        params.add(to);
        params.add(timestamp);
        params.add(sig);
        params.add(respDataType);
        //设置参数编码格式问题(不然有可能导致)
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, CharsetUtils.get("utf-8"));
        httpPost.setEntity(formEntity);
        //执行请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        String data = EntityUtils.toString(response.getEntity());
        System.out.println(data);
        return code;
    }


    public static String timeStampUtil() {
        return simpleDateFormat.format(new Date());
    }

    public static String sigNumberCreateUtil(String timeStamp) {
//        签名。MD5(ACCOUNT SID + AUTH TOKEN + timestamp)。共32位（小写）。
//        注意：MD5中的内容不包含"+"号。
        String sig = ACCOUNTSID + AUTHKEY + timeStamp;
        return DigestUtils.md5Hex(sig);
    }

//    public static void main(String[] args) throws IOException {
//        PhoneMessageCode.sendNote();
//    }

}