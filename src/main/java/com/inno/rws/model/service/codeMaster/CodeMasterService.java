package com.inno.rws.model.service.codeMaster;

import com.inno.rws.model.vo.CodeMasterVO;
import com.inno.rws.model.vo.PagingVO;
import com.inno.rws.model.vo.ResultVO;

public interface CodeMasterService {

    /**
     * 코드 마스터 리스트 조회
     * @param pagingVO
     * @return
     */
    ResultVO selectCodeMasterList(PagingVO pagingVO);

    /**
     * @apiNote 코드 마스터 저장
     * @param codeMasterVO
     * @return
     */
    ResultVO insertCodeMaster(CodeMasterVO codeMasterVO);

    /**
     * @apiNote 코드 마스터 수정
     * @param codeMasterVO
     * @return
     */
    ResultVO updateCodeMaster(CodeMasterVO codeMasterVO);

    /**
     * @apiNote 코드 마스터 삭제
     * @param codeMasterId
     * @return
     */
    ResultVO deleteCodeMaster(int codeMasterId);
}
