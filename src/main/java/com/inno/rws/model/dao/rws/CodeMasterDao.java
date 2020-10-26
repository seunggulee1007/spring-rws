package com.inno.rws.model.dao.rws;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.inno.rws.model.vo.CodeMasterVO;
import com.inno.rws.model.vo.PagingVO;

@Mapper
public interface CodeMasterDao {

    /**
     * @apiNote 코드 마스터 건수 조회
     * @return
     */
    int selectCodeMasterCnt();

    /**
     * @apiNote 코드 마스터 조회
     * @author leesg
     * @return
     */
    List<CodeMasterVO> selectCodeMasterList(PagingVO pagingVO);

    /**
     * @apiNote 코드 마스터 정보 등록
     * @author leesg
     * @param codeMasterVO
     * @return
     */
    int insertCodeMaster(CodeMasterVO codeMasterVO);
    
    /**
     * @apiNote 코드 마스터 정보 수정
     * @author leesg
     * @param codeMasterVO
     * @return
     */
    int updateCodeMaster(CodeMasterVO codeMasterVO);
    
    /**
     * @apiNote 코드 마스터 삭제
     * @author leesg
     * @param codeMasterId
     * @return
     */
    int deleteCodeMaster(int codeMasterId);
    
}
