package org.zkh.hotnews.provider.signin.service.impl;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.UserSigninService;
import org.zkh.hotnews.common.cache.RedisUtil;
import org.zkh.hotnews.common.data.dto.UserDTO;
import org.zkh.hotnews.common.data.entity.User;
import org.zkh.hotnews.common.service.UserDataService;
import static  org.zkh.hotnews.provider.signin.constant.RedisConstant.*;
@Service
@Slf4j
public class UserSigninServiceImpl implements UserSigninService {


    @Autowired
    UserDataService userDataService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Boolean signupUser(UserDTO userDTO) throws Exception {
        User user = new User().setName(userDTO.getName()).setPassword(userDTO.getPassword());

        return userDataService.save(user);
    }

    @Override
    public Boolean signinUser(Long userId, String password) throws Exception {

        User user = userDataService.lambdaQuery().eq(User::getId, userId).eq(User::getPassword, password).one();
        if (user== null) {
            return Boolean.FALSE;
        }else {
            redisUtil.set(USER_TOKEN+userId.toString(),"1");
        }
        log.info("user_token {}",redisUtil.get(USER_TOKEN+userId.toString()));
        return Boolean.TRUE;
    }

    @Override
    public Boolean verifyUserId(Long userId) throws Exception {
        String userToken = (String) redisUtil.get(userId.toString());
        if(userToken==null){
            return userDataService.lambdaQuery().eq(User::getId,userId).one()!= null;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean verifyUserName(String userName) throws Exception {
        return userDataService.verifyUserName(userName);
    }
}