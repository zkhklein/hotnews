package org.zkh.hotnews.api;

import org.zkh.hotnews.common.data.dto.UserDTO;

public interface UserSigninService {

    public Boolean signupUser(UserDTO userDTO) throws Exception;

    public Boolean signinUser(Long userId, String password) throws Exception;

    public Boolean verifyUserId(Long userId) throws Exception;
    public Boolean verifyUserName(String userName) throws Exception;
}
