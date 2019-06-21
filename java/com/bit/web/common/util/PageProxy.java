package com.bit.web.common.util;

import java.util.Map;

import com.bit.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class PageProxy {
    @Autowired Printer p;
    
    private int pageNum, pageSize, blockSize, startRow, endRow,
                startPage, endPage, prevBlock, nextBlock, totalCount;
    private String search;
    private boolean existPrev, existNext;

    public void execute(Map<?,?> paramMap){  //저쪽에서 서치나 페이지넘등이들어올꺼라서  뭔가 넘어올지몰라 와일드카드씀(물음표 내부적으로 오브젝트)
          
        // Dim - 1 Row scalar count 
        int totalCount = Integer.parseInt(String.valueOf(paramMap.get("totalCount")));
        
        // Dim -2 Page scalar info
        String _pageNum =  (String)paramMap.get("page_num");//내부에서 쓰는거 언더스코어   
        pageNum = (_pageNum ==null) ? 1 : Integer.parseInt(_pageNum);
        String _pageSize = (String)paramMap.get("page_size");  //_주는건 페이지넘을 사용하기 임시로 사용하는거  내부에서만 쓰는변수
        pageSize = (_pageNum ==null) ? 5 : Integer.parseInt(_pageSize);   //pageSize는 몇개를 볼꺼냐 예를들어15개씩 10개씪, list에 몇개있냐 할떄 list.size()를 씀 
        int nmg = totalCount % pageSize;   //왜냐면 블록구조를 만들어야해서
        int pageCount = (nmg ==0)? totalCount /pageSize : totalCount / pageSize +1;
        startRow = (pageNum -1)*pageSize;
        endRow = (totalCount > pageNum * pageSize) ? pageNum*pageSize : totalCount;
        // Dim -3 Block scalar info
        String _blockSize = (String)paramMap.get("block_size");
        blockSize = (_blockSize ==null) ? 5 : Integer.parseInt(_blockSize);
        int blockNum = (pageNum-1) / blockSize;   
        
        existPrev = (startPage - pageSize) > 0;
        existNext = (startPage + pageSize) <= pageCount;

        startPage = (existPrev) ? blockNum * blockSize +1 :1;
        endPage = (endPage> pageCount) ? pageCount : startPage + (blockSize-1);
        
        prevBlock = startPage - pageSize;
        nextBlock = startPage + pageSize;
        search = (String)paramMap.get("search");
        



    }
                
}