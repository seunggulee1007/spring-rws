package com.inno.rws.model.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.inno.rws.advice.exception.NoMemberException;
import com.inno.rws.model.dao.rws.UserDao;
import com.inno.rws.model.vo.UserDetailVO;
import com.inno.rws.model.vo.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserDao userDao;
    
    public UserDetails loadUserByUsername(String userPk) {
         UserVO userVO = userDao.selectUser(userPk).orElseThrow(NoMemberException::new);
         UserDetailVO user = UserDetailVO.builder().build();
         user.setUserId(userVO.getUserId());
         user.setPassword(userVO.getPassword());
         return user;
    }
}
