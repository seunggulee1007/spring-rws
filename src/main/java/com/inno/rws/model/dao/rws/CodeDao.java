package com.inno.rws.model.dao.rws;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.inno.rws.model.vo.CodeVO;
import com.inno.rws.model.vo.PagingVO;

@Mapper
public interface CodeDao {

    /**
     * @apiNote 코드 마스터 아이디로 코드 목록 조회
     * @author leesg
     * @param codeMasterId
     * @return
     */
    public List<CodeVO> selectCodeList(PagingVO pagingVO);
    
    /**
     * @apiNote 코드 정보 등록
     * @author leesg
     * @param codeVO
     * @return
     */
    public int insertCode(CodeVO codeVO);
    
    /**
     * @apiNote 코드 수정
     * @author leesg
     * @param codeVO
     * @return
     */
    public int updateCode(CodeVO codeVO);
    
    /**
     * @apiNote 코드 삭제
     * @author leesg
     * @param codeId
     * @return
     */
    public int deleteCode(int codeId);
    
    /**
     * @apiNote 코드 마스터 아이디로 코드 목록 전체 삭제
     * @author leesg
     * @param codeMasterId
     * @return
     */
    public int deleteCodeList(int codeMasterId);
    
}
