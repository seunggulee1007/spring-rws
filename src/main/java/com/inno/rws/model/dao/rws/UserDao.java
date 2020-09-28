package com.inno.rws.model.dao.rws;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.inno.rws.model.vo.UserVO;

@Mapper
public interface UserDao {

    public Optional<UserVO> selectUser(String userId);
    
    public int insertUser(UserVO userVO);
    
    public int updatePwd(UserVO userVO);
    
}
