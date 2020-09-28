package com.inno.rws.model.dao.rws;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.inno.rws.model.vo.PostVO;

@Mapper
public interface PostDao {

    public Optional<PostVO> selectPost(int postId);
    
    public int insertPost(PostVO postVO);
    
    public List<PostVO> selectPostList(String crtId);
    
    public int deletePost(int postId);
    
    public int updatePost(PostVO postVO);
    
}
