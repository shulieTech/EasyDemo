package com.easydemo.gateway.util;

import com.alibaba.fastjson.JSON;
import com.easydemo.gateway.resp.RtnResp;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author <a href="mailto:mitsui#shulie.io">mitsui</a>
 * @version 1.0
 * @date 2021-06-25
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static RtnResp doHttpPost(String jsonDate, String reqUrl) {
        byte[] xmlData = jsonDate.getBytes();
        InputStream instr = null;
        java.io.ByteArrayOutputStream out = null;
        try {
            URL url = new URL(reqUrl);
            // 打开和URL之间的连接
            URLConnection urlCon = url.openConnection();

            // 发送POST请求必须设置如下两行
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);

            urlCon.setUseCaches(false);

            // 设置请求属性
            urlCon.setRequestProperty("content-Type", "application/json");
            urlCon.setRequestProperty("charset", "utf-8");
            urlCon.setRequestProperty("Content-length",
                    String.valueOf(xmlData.length));
            DataOutputStream printout = new DataOutputStream(
                    urlCon.getOutputStream());

            // 发送请求参数
            printout.write(xmlData);
            printout.flush();
            printout.close();
            instr = urlCon.getInputStream();
            byte[] bis = IOUtils.toByteArray(instr);
            String responseString = new String(bis, "UTF-8");
            return JSON.parseObject(responseString, RtnResp.class);
        } catch (Exception e) {
            logger.error("远程调用失败:{}", e);
            return RtnResp.failure("远程调用失败：" + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (instr != null) {
                    instr.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
