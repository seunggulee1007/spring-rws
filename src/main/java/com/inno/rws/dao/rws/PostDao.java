package com.inno.rws.dao.rws;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.inno.rws.vo.PostVO;

@Mapper
public interface PostDao {

    public Optional<PostVO> selectPost(int postId);
    
    public int insertPost(PostVO postVO);
    
    public Optional<List<PostVO>> selectPostList(String crtId);
    
}
