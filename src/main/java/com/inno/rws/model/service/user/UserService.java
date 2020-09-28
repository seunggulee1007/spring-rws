package com.inno.rws.model.service.user;

import com.inno.rws.advice.exception.AlreadyMemberException;
import com.inno.rws.model.vo.ResultVO;
import com.inno.rws.model.vo.UserVO;

public interface UserService {

    public ResultVO signUp(UserVO userVO) throws AlreadyMemberException;
    
    public ResultVO signIn(UserVO userVO);
    
    public ResultVO chgPwd(UserVO userVO);
    
}
