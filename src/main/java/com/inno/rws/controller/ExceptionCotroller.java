package com.inno.rws.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.rws.advice.exception.CAuthenticationEntryPointException;
import com.inno.rws.model.vo.ResultVO;

@RestController
@RequestMapping("/exception")
public class ExceptionCotroller {

    @GetMapping(value = "/entrypoint")
    public ResultVO entrypointException() {
        throw new CAuthenticationEntryPointException();
    }
    
    @GetMapping(value = "/accessdenied")
    public ResultVO accessdeniedException() {
        throw new AccessDeniedException("");
    }
}
