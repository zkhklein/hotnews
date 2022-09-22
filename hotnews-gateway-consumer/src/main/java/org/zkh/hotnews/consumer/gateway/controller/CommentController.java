package org.zkh.hotnews.consumer.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zkh.hotnews.common.result.ResultDTO;
import org.zkh.hotnews.data.dto.AttitudeToCommentDTO;
import org.zkh.hotnews.data.dto.AttitudeToPaperDTO;
import org.zkh.hotnews.data.dto.CommentDTO;
import org.zkh.hotnews.data.dto.PaperDTO;
import org.zkh.hotnews.data.entity.AttitudeToComment;

@RestController
@RequestMapping("/comment")
@ResponseBody
public class CommentController {

    @PostMapping("/view")
    public ResultDTO sendComment(@RequestParam("id") Long id){
//id paper
    }

    @PostMapping("/send")
    public ResultDTO sendComment(@RequestBody CommentDTO commentDTO){

    }

    @PostMapping("/attitude/view")
    public ResultDTO viewMyAttitude(@RequestBody AttitudeToCommentDTO attitudeDTO){

    }


    @PostMapping("/attitude/count")
    public ResultDTO countAttitude(@RequestParam("id") Long id){
// AttitudeCountDTO
    }

    @PostMapping("/attitude/do")
    public ResultDTO doMyAttitude(@RequestBody AttitudeToCommentDTO attitudeDTO){

    }

}
