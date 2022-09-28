package org.zkh.hotnews.consumer.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zkh.hotnews.api.AudienceCommentService;
import org.zkh.hotnews.common.result.ResultDTO;
import org.zkh.hotnews.common.data.dto.AttitudeToCommentDTO;
import org.zkh.hotnews.common.data.dto.CommentDTO;
import org.zkh.hotnews.provider.audience.service.impl.AudienceCommentServiceImpl;

@RestController
@RequestMapping("/comment")
@ResponseBody
public class CommentController {

    @Autowired
    AudienceCommentService audienceCommentService;

    @PostMapping("/view")
    public ResultDTO viewComment(@RequestParam("id") Long id) throws Exception {
        return ResultDTO.ok(audienceCommentService.viewComment(id));
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
