package com.inno.rws.model.service.post;

import org.springframework.stereotype.Service;

import com.inno.rws.advice.exception.NoDataFoundException;
import com.inno.rws.dao.rws.PostDao;
import com.inno.rws.enums.CommonMsg;
import com.inno.rws.vo.PostVO;
import com.inno.rws.vo.ResultVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServicecImpl implements PostService{

    private final PostDao postDao;
    
    public ResultVO selectPost(int postId) {
        return ResultVO.builder().data(postDao.selectPost(postId).orElseThrow(NoDataFoundException::new)).build();
    }
    
    public ResultVO insertPost(PostVO postVO) {
        int result = 0;
        String resultMsg = CommonMsg.SUCCESS_WRITE.getMsg();
        if(postDao.insertPost(postVO) < 1) {
            result = -1;
            resultMsg = CommonMsg.FAIL_WRITE.getMsg();
        }
        return ResultVO.builder().result(result).resultMsg(resultMsg).build();
    }
    
    public ResultVO selectPostList(String crtId) {
        return ResultVO.builder().data(postDao.selectPostList(crtId).orElseThrow(NoDataFoundException::new)).build();
    }
    
}
