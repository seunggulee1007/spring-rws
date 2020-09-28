package com.inno.rws.model.vo.work;

import com.inno.rws.model.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class WorkEtc extends CommonVO {

    /** 근무 시간 기타 아이디 */
    private int workEtcId;
    /** 근무기준 아이디 */
    private int workBaseId;
    /** 기타 종류 */
    private String etcType;
    /** 기타 시작 시간 */
    private String etcStartTm;
    /** 기타 종료 시간 */
    private String etcEndTm;
    /** 기타 총 시간 */
    private int etcTotTm;
    
}
