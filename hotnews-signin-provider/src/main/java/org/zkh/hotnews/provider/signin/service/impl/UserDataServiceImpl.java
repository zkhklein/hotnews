package org.zkh.hotnews.provider.signin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.zkh.hotnews.mapper.UserMapper;
import org.zkh.hotnews.provider.signin.service.UserDataService;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.data.entity.User;

/**
 * @author S9049660
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserMapper, User> implements UserDataService {
}
