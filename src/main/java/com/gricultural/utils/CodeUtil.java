package com.gricultural.utils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpSession;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/10 3:12
 * @Description:验证码 工具类
 */
public class CodeUtil {
    /**
    * @Author: chongchong
    * @Description: 验证码校验
    * @DateTime: 2023/3/10 3:12
    * @Params: 
    * @Return 
    */
    public static boolean checkVerifyCode(HttpSession session, String key) {
        // 获取生成的验证码
        String verifyCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("verifyCode: " + verifyCode);
        // 获取用户输入的验证码
        if (key == null || !key.equals(verifyCode)) {
            return false;
        }
        return true;
    }
}
