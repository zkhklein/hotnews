package org.zkh.hotnews.consumer.gateway.controller;


import org.springframework.web.bind.annotation.*;
import org.zkh.hotnews.common.result.ResultDTO;
import org.zkh.hotnews.data.dto.UserDTO;

@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @PostMapping("/signup")
    public ResultDTO signup(@RequestBody UserDTO userDTO) {

    }

    @PostMapping("/signin")
    public ResultDTO signin(@RequestBody UserDTO userDTO) {

    }
}
