package com.inno.rws.advice.exception;

import com.inno.rws.enums.CommonMsg;

/**
 * 버전 체크
 * @author es-seungglee
 *
 */
public class NoMemberException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1291658484551919953L;
    public NoMemberException(String msg, Throwable t) {
        super(msg, t);
    }
     
    public NoMemberException(String msg) {
        super(msg);
    }
     
    public NoMemberException() {
        super(CommonMsg.NO_MEMBER.getMsg());
    }

}
