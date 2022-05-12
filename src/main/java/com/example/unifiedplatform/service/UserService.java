package com.example.unifiedplatform.service;

import com.example.unifiedplatform.controller.form.LoginForm;
import com.example.unifiedplatform.entity.User;
import com.example.unifiedplatform.exception.PlatformException;
import com.example.unifiedplatform.exception.ResultEnum;
import com.example.unifiedplatform.repository.UserRepository;
import com.example.unifiedplatform.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * 登录，返回token
     * @param loginForm
     * @return
     */
    public String login(LoginForm loginForm){
        String account = loginForm.getAccount();
        User user = findByEmailOrTelephone(account);
        if(user==null){
            throw new PlatformException(ResultEnum.USER_NOT_EXIST);
        }
        if(!user.getPassword().equals(loginForm.getPassword())){
            throw new PlatformException(ResultEnum.PWD_ERROR);
        }
        return TokenUtil.getToken(user);
    }

    /**
     * 根据账号查找用户
     * @param account
     * @return
     */
    public User findByEmailOrTelephone(String account){
        User user = userRepository.findByEmail(account);
        if(user==null){
            user = userRepository.findByTelephone(account);
        }
        return user;
    }
}
