package com.inno.rws.dao.rws;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.inno.rws.vo.UserVO;

@Mapper
public interface UserDao {

    public Optional<UserVO> selectUser(String userId);
    
    public int insertUser(UserVO userVO);
    
}
