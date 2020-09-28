package com.inno.rws.model.dao.rws;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.inno.rws.model.vo.CodeMasterVO;
import com.inno.rws.model.vo.PagingVO;

@Mapper
public interface CodeMasterDao {
    
    /**
     * @apiNote 코드 마스터 조회
     * @author leesg
     * @return
     */
    public List<CodeMasterVO> selectCodeMasterList(PagingVO pagingVO);

    /**
     * @apiNote 코드 마스터 정보 등록
     * @author leesg
     * @param codeMasterVO
     * @return
     */
    public int insertCodeMaster(CodeMasterVO codeMasterVO);
    
    /**
     * @apiNote 코드 마스터 정보 수정
     * @author leesg
     * @param codeMasterVO
     * @return
     */
    public int updateCodeMaster(CodeMasterVO codeMasterVO);
    
    /**
     * @apiNote 코드 마스터 삭제
     * @author leesg
     * @param codeMasterId
     * @return
     */
    public int deleteCodeMaster(int codeMasterId);
    
}
