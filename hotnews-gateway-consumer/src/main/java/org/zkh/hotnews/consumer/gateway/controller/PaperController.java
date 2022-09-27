package org.zkh.hotnews.consumer.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zkh.hotnews.api.PaperSendService;
import org.zkh.hotnews.common.result.ResultDTO;
import org.zkh.hotnews.common.data.dto.AttitudeToPaperDTO;
import org.zkh.hotnews.common.data.dto.PaperDTO;

@RestController
@RequestMapping("/paper")
@ResponseBody
public class PaperController {

    @Autowired
    PaperSendService paperSendService;
    @PostMapping("/view")
    public ResultDTO viewPaper(@RequestParam("id") Long id) {
        return ResultDTO.ok();
    }

    @PostMapping("/send")
    public ResultDTO sendPaper(@RequestBody PaperDTO paperDTO) throws Exception {

        return ResultDTO.ok(paperSendService.sendPaper(paperDTO));
    }


    @PostMapping("/likeNum/view")
    public ResultDTO viewlikeNum(@RequestBody AttitudeToPaperDTO attitudeDTO) {
        return ResultDTO.ok();
    }


    @PostMapping("/attitude/count")
    public ResultDTO countAttitude(@RequestParam("id") Long id) {
// AttitudeCountDTO
        return ResultDTO.ok();
    }

    @PostMapping("/attitude/do")
    public ResultDTO doMyAttitude(@RequestBody AttitudeToPaperDTO attitudeDTO) {
        return ResultDTO.ok();
    }
}
