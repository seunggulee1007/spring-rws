package com.inno.rws.model.service.user;

import java.rmi.AlreadyBoundException;

import com.inno.rws.vo.ResultVO;
import com.inno.rws.vo.UserVO;

public interface UserService {

    public ResultVO signUp(UserVO userVO)  throws AlreadyBoundException;
    
    public ResultVO signIn(UserVO userVO);
    
}
