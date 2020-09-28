package com.inno.rws.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inno.rws.advice.exception.AlreadyMemberException;
import com.inno.rws.advice.exception.BizServiceException;
import com.inno.rws.advice.exception.CAuthenticationEntryPointException;
import com.inno.rws.advice.exception.CommonUtilException;
import com.inno.rws.advice.exception.FalseIDException;
import com.inno.rws.advice.exception.NoMemberException;
import com.inno.rws.advice.exception.NoVersionException;
import com.inno.rws.enums.CommonCode;
import com.inno.rws.model.vo.ResultVO;

import lombok.RequiredArgsConstructor;

/**
 * 커스텀 예외 처리
 * @author es-seungglee
 *
 */
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice{

    @ExceptionHandler(Exception.class)
    protected ResultVO defaultException(Exception e) {
        ResultVO resultVO = ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
        return resultVO;
    }
    
    @ExceptionHandler(NoVersionException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResultVO noVersionException(Exception e) {
        ResultVO resultVO = ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
        return resultVO;
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultVO accessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        ResultVO resultVO = ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
        return resultVO;
    }
    
    @ExceptionHandler(CAuthenticationEntryPointException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultVO CEmailSigninFailedException(CAuthenticationEntryPointException e, HttpServletRequest request) {
        ResultVO resultVO = ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg("해당 리소스에 접근하기 위한 권한이 없습니다.")
                .build();
        return resultVO;
    }
    
    @ExceptionHandler(NoMemberException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultVO NoMemberException(NoMemberException e, HttpServletRequest request) {
        ResultVO resultVO = ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
        return resultVO;
        
    }
    
    @ExceptionHandler(AlreadyMemberException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultVO AlreadyMemberException(AlreadyMemberException e, HttpServletRequest request) {
        ResultVO resultVO = ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
        return resultVO;
    }
    
    @ExceptionHandler(FalseIDException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultVO FalseIDException(FalseIDException e, HttpServletRequest request) {
        ResultVO resultVO = ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
        return resultVO;
    }
    
    @ExceptionHandler(BizServiceException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResultVO BizServiceException(BizServiceException e, HttpServletRequest request) {
        return ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
    }
    
    @ExceptionHandler(CommonUtilException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResultVO CommonUtilException(CommonUtilException e, HttpServletRequest request) {
        return ResultVO.builder()
                .result(CommonCode.FAIL.getCode())
                .resultMsg(e.getMessage())
                .errMsg(e.getStackTrace()[0].toString())
                .build();
    }
    
}
