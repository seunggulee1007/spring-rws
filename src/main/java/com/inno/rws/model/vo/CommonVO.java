package com.inno.rws.model.vo;

import lombok.Data;

@Data
public class CommonVO {

    /** 등록자 */
    private String crtId;
    /** 등록일자 */
    private String crtDtm;
    /** 수정자 */
    private String chgId;
    /** 수정일자 */
    private String chgDtm;
    
}
