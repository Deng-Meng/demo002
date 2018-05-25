/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Md5Encryption
 * Author:   DM-admin
 * Date:     2018/5/18 13:55
 * Description: 加密
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dm.demo002.uitl;

import com.sun.media.jfxmedia.track.Track;
import org.omg.IOP.Encoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

import javax.validation.groups.Default;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.zip.Deflater;

/**
 * 〈一句话功能简述〉<br>
 * 〈加密〉
 *
 * @author DM-admin
 * @create 2018/5/18
 * @since 1.0.0
 */
public class Md5Encryption {
    public static String str2MD5(String strs) {
                 /*
11          * 加密需要使用JDK中提供的类
12          */
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(strs.getBytes());
                      /*
18              * 加密后的数据是-128 到 127 之间的数字，这个数字也不安全。
19              * 取出每个数组的某些二进制位进行某些运算，得到一个新的加密结果
20              *
21              *  0000 0011 0000 0100 0010 0000 0110 0001
22              * &0000 0000 0000 0000 0000 0000 1111 1111
23              * ---------------------------------------------
24              *  0000 0000 0000 0000 0000 0000 0110 0001
25              *
26              *  把取出的数据转成十六进制数
27              */
            for (byte b : bs) {
                int x = b & 255;
                String s = Integer.toHexString(x);
                if (x < 16) {
                    sb.append("0");
                }
                sb.append(s);
            }

        } catch (Exception e) {
            System.out.println("加密失败");
        }
        return sb.toString();
    }

}