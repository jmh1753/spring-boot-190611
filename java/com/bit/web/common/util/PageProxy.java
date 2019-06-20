package com.bit.web.common.util;

import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class PageProxy {

    private int pageNum, pageSize, blockSize, startRow, endRow,
                startPage, endPage, prevBlock, nextBlock, totalCount;
    private String search;
    private boolean existPrev, existNext;

    public void execute(Map<?,?> paramMap){  //저쪽에서 서치나 페이지넘등이들어올꺼라서  뭔가 넘어올지몰라 와일드카드씀(물음표 내부적으로 오브젝트)
        String _pageNum =  (String)paramMap.get("page_num");//내부에서 쓰는거 언더스코어   
        pageNum = (_pageNum ==null) ? 1 : Integer.parseInt(_pageNum);
        String _pageSize = (String)paramMap.get("page_size");  //_주는건 페이지넘을 사용하기 임시로 사용하는거  내부에서만 쓰는변수
        pageSize = (_pageNum ==null) ? 5 : Integer.parseInt(_pageSize);   //pageSize는 몇개를 볼꺼냐 예를들어15개씩 10개씪, list에 몇개있냐 할떄 list.size()를 씀 

        //blocksize 기본값 5 
        String _blockSize = (String)paramMap.get("block_size");
        blockSize = (totalCount / 5) + 1;
        //blockSize = (_blockSize==null) ?
        // totalCount = DB 에 있는 테이블에서  마이바티스에 이미 있음 서비스에있는 겟카운터가져오기


        int nmg = totalCount % pageSize;   //왜냐면 블록구조를 만들어야해서
        int pageCount = (nmg ==0)? totalCount /pageSize : totalCount / pageSize +1;

        //startRow 2페이지면 6~10  3페이지면 11~15


        //endRow


    }
                
}