package org.zkh.hotnews.common.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.common.data.entity.User;
import org.zkh.hotnews.common.mapper.UserMapper;
import org.zkh.hotnews.common.data.service.UserDataService;

/**
 * @author S9049660
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserMapper, User> implements UserDataService {

    @Override
    public Boolean verifyUserName(String userName) throws Exception {
        return lambdaQuery().eq(User::getName,userName).one() == null;
    }

}
