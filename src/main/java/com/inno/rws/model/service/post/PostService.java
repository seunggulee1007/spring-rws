package com.inno.rws.model.service.post;

import com.inno.rws.model.vo.PostVO;
import com.inno.rws.model.vo.ResultVO;

public interface PostService {

    public ResultVO selectPost(int postId);
    
    public ResultVO insertPost(PostVO postVO);
    
    public ResultVO selectPostList(String crtId);
    
    public ResultVO deletePost(int postId);
    
    public ResultVO updatePost(PostVO postVO);
    
}
