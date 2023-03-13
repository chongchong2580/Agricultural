package com.gricultural.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.gricultural.utils.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/9 2:07
 * @Description:系统登录相关api
 */
@Api(value = "验证码生成",tags = {"验证码操作接口"})
@RestController
public class SysLoginController {

    @Resource
    private Producer producer;

    @GetMapping("/kaptcha")
    @ApiOperation(value = "生成验证码")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setHeader("Cache-Control","no-store,no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        response.setHeader("Set-Cookie", text + "; SameSite=None;Secure");
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        System.out.println("验证码生成：" + request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));

        System.err.println(text);
        System.err.println(image);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpg",out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("/loginJuge")
    @ApiOperation(value = "验证验证码")
    public String login(HttpSession session, String code) {
        System.out.println("code: " + code);
        if (!CodeUtil.checkVerifyCode(session, code)) {
            return "验证码错误！";
        } else {
            return "验证码正确！";
        }
    }

}
