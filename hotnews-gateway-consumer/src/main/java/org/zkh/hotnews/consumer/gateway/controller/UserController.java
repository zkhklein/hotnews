package org.zkh.hotnews.consumer.gateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zkh.hotnews.api.UserSigninService;
import org.zkh.hotnews.common.result.ResultDTO;
import org.zkh.hotnews.common.data.dto.UserDTO;

import static org.zkh.hotnews.common.result.ResponseStatusEnum.USER_INFO_UPDATED_NICKNAME_EXIST_ERROR;

@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    UserSigninService userSigninService;

    @PostMapping("/signup")
    public ResultDTO signup(@RequestBody UserDTO userDTO) throws Exception {

        if(userSigninService.verifyUserName(userDTO.getName())){
            return ResultDTO.ok(userSigninService.signupUser(userDTO));
        }else {
            return ResultDTO.errorCustom(USER_INFO_UPDATED_NICKNAME_EXIST_ERROR);
        }
    }

    @PostMapping("/signin")
    public ResultDTO signin(@RequestBody UserDTO userDTO) throws Exception{
        return ResultDTO.ok(userSigninService.signinUser(userDTO.getId(),userDTO.getPassword()));
    }
}
