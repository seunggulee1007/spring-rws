package com.inno.rws.model.service.post;

import java.util.List;
import java.util.Optional;

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
        Optional<List<PostVO>> optional = Optional.ofNullable(postDao.selectPostList(crtId));
        return ResultVO.builder().data(optional.orElseThrow(NoDataFoundException::new)).build();
    }

    public ResultVO deletePost(int postId) {
        int result = 0;
        String resultMsg = CommonMsg.SUCCESS_DELETE.getMsg();
        if(postDao.deletePost(postId) < 1) {
            result = -1;
            resultMsg = CommonMsg.FAIL_DELETE.getMsg();
        }
        
        return ResultVO.builder().result(result).resultMsg(resultMsg).build();
    }
    
    public ResultVO updatePost(PostVO postVO) {
        int result = 0;
        String resultMsg = CommonMsg.SUCCESS_MODIFY.getMsg();
        if(postDao.updatePost(postVO) < 1) {
            result = -1;
            resultMsg = CommonMsg.FAIL_MODIFY.getMsg();
        }
        return ResultVO.builder().result(result).resultMsg(resultMsg).build();
        
    }
}
