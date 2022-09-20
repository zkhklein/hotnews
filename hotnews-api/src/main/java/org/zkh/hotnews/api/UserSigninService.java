package org.zkh.hotnews.api;

import org.zkh.hotnews.data.dto.UserDTO;

public interface UserSigninService {

    public Boolean signupUser(UserDTO userDTO) throws Exception;

    public Boolean signinUser(Long userId,String password) throws Exception;

    public Boolean verifyUser(Long userId) throws Exception;

}
