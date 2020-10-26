package com.inno.rws.controller;

import com.inno.rws.model.vo.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class CommuteController {

    public ResultVO getToWork() {

        return ResultVO.builder().build();
    }
}
