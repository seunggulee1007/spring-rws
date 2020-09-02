package com.inno.rws.model.service.user;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.inno.rws.advice.exception.FalseIDException;
import com.inno.rws.advice.exception.NoMemberException;
import com.inno.rws.config.JwtTokenProvider;
import com.inno.rws.dao.rws.UserDao;
import com.inno.rws.enums.CommonMsg;
import com.inno.rws.vo.ResultVO;
import com.inno.rws.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    
    public ResultVO signUp(UserVO userVO) throws AlreadyBoundException {
        UserVO user = userDao.selectUser(userVO.getUserId()).orElseGet(() -> new UserVO());
        if(!StringUtils.isEmpty(user.getUserId())) {
            throw new AlreadyBoundException();
        }
        userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
        userDao.insertUser(userVO);
        return ResultVO.builder().resultMsg("등록되었습니다").build();
    }
    
    public ResultVO signIn(UserVO userVO) {
        List<String> authorities = new ArrayList<>();
        UserVO user = userDao.selectUser(userVO.getUserId()).orElseThrow(NoMemberException::new);
        authorities.add("ROLE_USER");
        if (!passwordEncoder.matches(userVO.getPassword(), user.getPassword())) throw new FalseIDException();
        String token = jwtTokenProvider.createToken(user.getUserId(), authorities);
        Map<String, Object> map = new HashMap<>();
        userVO.setUserNm(user.getUserNm());
        map.put("authToken", token);
        map.put("user", userVO);
        return ResultVO.builder().data(map).resultMsg(CommonMsg.SUCCESS_LOGIN.getMsg()).build();
    }

}
