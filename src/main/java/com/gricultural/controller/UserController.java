package com.gricultural.controller;


import com.google.code.kaptcha.Constants;
import com.gricultural.mapper.UserDao;
import com.gricultural.pojo.User;
import com.gricultural.utils.QiniuUtils;
import com.gricultural.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@Api(value = "用户管理",tags = {"用户管理接口"})
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    // 用户登录
    @PostMapping(value = "/userLogin")
    @ApiOperation(value = "验证账号密码登录")
    public R userLogin(@RequestBody User loginUser, HttpServletRequest request, RedirectAttributes redirect) {
        // 通过用户名查找User对象
        User user = userDao.getUserByUserName(loginUser.getUsername());
        System.err.println(user.getUsername());
        String password = "";
        if (user != null) {
            password = userDao.getUserPasswordByUserName(user.getUsername());
            System.err.println(password);
        }

        System.err.println(loginUser.getPassword());
        // 判断登录信息是否正确
        if (user != null && loginUser.getPassword().equals(password)) {
            // 登陆成功，跳转到主页
            request.getSession().setAttribute("username", user.getUsername());
//            return "redirect:/batch/findAll";
            return new R("1000",true,userDao.getUserByUserName(loginUser.getUsername()),"登录成功");
        } else {
            // 登录失败，跳转页面
            request.setAttribute("Msg", "登录失败");
//            return "error";
            return new R("500",false,userDao.getUserByUserName(loginUser.getUsername()),"登录失败");
        }
    }

    @ApiOperation(value = "验证验证码、账号密码登录")
    @PostMapping(value = "/userJugeLogin")
    public R userJugeLogin(@RequestBody User loginUser, HttpServletRequest request, RedirectAttributes redirect, HttpSession session,@RequestParam String code) {
        // 通过用户名查找User对象
        User user = userDao.getUserByUserName(loginUser.getUsername());
        String password = "";
        if (user != null) {
            password = userDao.getUserPasswordByUserName(user.getUsername());
        }
        System.out.println("code: " + code);
        String verifyCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("session_verifyCode:" + verifyCode);
        // 判断登录信息是否正确
        if (user != null && loginUser.getPassword().equals(password)) {
            request.getSession().setAttribute("username", user.getUsername());

            if (code == null || !code.equals(verifyCode)) {
//            if (!CodeUtil.checkVerifyCode(session, code)) {
                request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
                return new R("500",false,code,"验证码错误");
            } else {
                return new R("1000",true,code,"验证码正确");
            }
        } else {
            return new R("500",false,code,"登录失败");
        }

        // 登录失败，跳转页面
//        request.setAttribute("Msg", "登录失败");
//        return "error";
    }


    // 用户注销功能
    @RequestMapping(value = "/loginOut")
    @ApiOperation(value = "注销登录")
    public String loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("username");
        return "index";
    }


    //用户修改
    @PutMapping("/updateUserById")
    @ApiOperation(value = "修改用户信息不包括图片")
    public R updateUserById(@RequestBody User user) {
        if (userDao.updateUserById(user)) {
            return new R("1000",true,userDao.updateUserById(user),"更新数据成功");
        } else {
            return new R("500",false,userDao.updateUserById(user),"更新数据失败");
        }
    }

    //用户修改
    @PutMapping("/updateUserByIdImg")
    @ApiOperation(value = "修改用户信息包括图片")
    public R updateUserByIdImg(@RequestParam Integer id,@RequestParam String username,@RequestParam String password,
                               @RequestParam("imgFile") MultipartFile imgFile) {
        String url = null;
        String filename = imgFile.getOriginalFilename();
        try {
            if (userDao.updateUserByIdImg(id,username,password,filename)) {
                QiniuUtils.upload2Qiniu(imgFile.getBytes(), filename);
                url = "http://rrb01tjz7.hn-bkt.clouddn.com/" + filename;
                return new R("1000",true,userDao.updateUserByIdImg(id,username,password,url),"更新数据成功");
            } else {
                return new R("500",false,userDao.updateUserByIdImg(id,username,password,url),"更新数据失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //图片上传
    @PostMapping("uploadImg")
    @ApiOperation(value = "上传图片")
    public R upload(@RequestParam("imgFile") MultipartFile imgFile) {
        String filename = imgFile.getOriginalFilename();
        try {
            QiniuUtils.upload2Qiniu(imgFile.getBytes(), filename);
            String url = "http://rrb01tjz7.hn-bkt.clouddn.com/" + filename;
            return new R("2000",true, filename,"图片上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
