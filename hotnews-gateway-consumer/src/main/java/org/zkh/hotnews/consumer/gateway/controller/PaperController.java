package org.zkh.hotnews.consumer.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zkh.hotnews.common.result.ResultDTO;
import org.zkh.hotnews.data.dto.AttitudeToPaperDTO;
import org.zkh.hotnews.data.dto.PaperDTO;

@RestController
@RequestMapping("/paper")
@ResponseBody
public class PaperController {

    @PostMapping("/view")
    public ResultDTO viewPaper(@RequestParam("id") Long id){

    }

    @PostMapping("/send")
    public ResultDTO sendPaper(@RequestBody PaperDTO paperDTO){

    }


    @PostMapping("/attitude/view")
    public ResultDTO viewMyAttitude(@RequestBody AttitudeToPaperDTO attitudeDTO){

    }


    @PostMapping("/attitude/count")
    public ResultDTO countAttitude(@RequestParam("id") Long id){
// AttitudeCountDTO
    }

    @PostMapping("/attitude/do")
    public ResultDTO doMyAttitude(@RequestBody AttitudeToPaperDTO attitudeDTO){

    }
}
