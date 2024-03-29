package com.example.yin.controller;

import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.pojo.User;
import com.example.yin.pojo.vo.UserDefine;
import com.example.yin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Object getUserByAccount() {
        return new SuccessMessage<List<User>>(null, userService.getAllUsers()).getMessage();
    }

    @PostMapping("/register")
    public Object register(HttpServletRequest req) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        if (account == null || password == null) return new ErrorMessage("请输入完整的账户和密码").getMessage();
        for(User user : userService.getAllUsers()) {
            if (account.equals(user.getAccount())) {
                return new ErrorMessage("该账号已注册").getMessage();
            }
        }
        return new SuccessMessage<Boolean>("注册成功", userService.registerUser(account, password)).getMessage();
    }

    @PostMapping("/login")
    public Object login(HttpServletRequest req) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        if (account == null || password == null) return new ErrorMessage("请输入完整的账户和密码").getMessage();
        int flag = userService.loginUser(account, password);
        if (flag == -1) return new ErrorMessage("您尚未注册").getMessage();
        else if (flag == 0) return new ErrorMessage("您的账号或者密码有误").getMessage();
        else return new SuccessMessage<User>("登录成功", userService.getUserByAccount(account)).getMessage();
    }

    @PostMapping("/user/update")
    public Object updateDetails(HttpServletRequest req) {
        UserDefine userDefine = new UserDefine(
                Integer.valueOf(req.getParameter("id")),
                req.getParameter("nickname"),
                req.getParameter("phone"),
                req.getParameter("email"),
                req.getParameter("wechatId")
        );
        return new SuccessMessage<Boolean>("更新用户信息成功", userService.updateDeails(userDefine)).getMessage();
    }
}
