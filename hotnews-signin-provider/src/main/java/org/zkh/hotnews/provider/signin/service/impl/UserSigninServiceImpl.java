package org.zkh.hotnews.provider.signin.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.UserSigninService;
import org.zkh.hotnews.data.dto.UserDTO;
import org.zkh.hotnews.data.entity.User;
import org.zkh.hotnews.provider.signin.service.UserDataService;

@Service  //暴露服务
@Slf4j
public class UserSigninServiceImpl implements UserSigninService {


    @Autowired
    UserDataService userDataService;

    @Override
    public Boolean signupUser(UserDTO userDTO) throws Exception {
        return null;
    }

    @Override
    public Boolean signinUser(Long userId, String password) throws Exception {
        User user = userDataService.lambdaQuery().eq(User::getId,userId).eq(User::getPassword,password).one();
        if(user.getId()==null){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean verifyUser(Long userId) throws Exception {
        return null;
    }
}