package org.zkh.hotnews.provider.signin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.UserSigninService;
import org.zkh.hotnews.common.data.dto.UserDTO;
import org.zkh.hotnews.common.data.entity.User;
import org.zkh.hotnews.common.data.service.UserDataService;

@Service  //暴露服务
public class UserSigninServiceImpl implements UserSigninService {


    @Autowired
    UserDataService userDataService;

    @Override
    public Boolean signupUser(UserDTO userDTO) throws Exception {
        User user = new User().setName(userDTO.getName()).setPassword(userDTO.getPassword());

        return userDataService.save(user);
    }

    @Override
    public Boolean signinUser(Long userId, String password) throws Exception {
        User user = userDataService.lambdaQuery().eq(User::getId, userId).eq(User::getPassword, password).one();
        if (user.getId() == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean verifyUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public Boolean verifyUserName(String userName) throws Exception {
        return userDataService.verifyUserName(userName);
    }
}