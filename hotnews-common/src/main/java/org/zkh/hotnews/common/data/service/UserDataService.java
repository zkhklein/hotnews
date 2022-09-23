package org.zkh.hotnews.common.data.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zkh.hotnews.common.data.entity.User;

/**
 * @author S9049660
 */
public interface UserDataService extends IService<User> {

    public Boolean verifyUserName(String userName) throws Exception;

}
