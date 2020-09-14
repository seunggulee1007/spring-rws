package com.inno.rws.model.service.biz;

import java.io.IOException;

import com.inno.rws.vo.ResultVO;

public interface BizService {

    public ResultVO getBizInfo(String bizNo) throws IOException;
    
}
