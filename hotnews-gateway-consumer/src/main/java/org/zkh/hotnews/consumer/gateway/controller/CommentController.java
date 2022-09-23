package org.zkh.hotnews.consumer.gateway.controller;

import org.springframework.web.bind.annotation.*;
import org.zkh.hotnews.common.result.ResultDTO;
import org.zkh.hotnews.common.data.dto.AttitudeToCommentDTO;
import org.zkh.hotnews.common.data.dto.CommentDTO;

@RestController
@RequestMapping("/comment")
@ResponseBody
public class CommentController {

    @PostMapping("/view")
    public ResultDTO sendComment(@RequestParam("id") Long id) {
//id paper
        return ResultDTO.ok();
    }

    @PostMapping("/send")
    public ResultDTO sendComment(@RequestBody CommentDTO commentDTO) {
        return ResultDTO.ok();
    }

    @PostMapping("/attitude/view")
    public ResultDTO viewMyAttitude(@RequestBody AttitudeToCommentDTO attitudeDTO) {
        return ResultDTO.ok();
    }


    @PostMapping("/attitude/count")
    public ResultDTO countAttitude(@RequestParam("id") Long id) {
// AttitudeCountDTO
        return ResultDTO.ok();
    }

    @PostMapping("/attitude/do")
    public ResultDTO doMyAttitude(@RequestBody AttitudeToCommentDTO attitudeDTO) {
        return ResultDTO.ok();
    }

}
