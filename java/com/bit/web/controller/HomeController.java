package com.bit.web.controller;

import com.bit.web.common.util.Printer;
import com.bit.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller  //빈으로 등록  홈컨트롤러가 클래스임  근데 빈으로 등록된 클래스임 그냥 빈이라 하면됨 , 객체를 생성하고 빈을 안만들면 쓸수 없음 soap방식
public class HomeController {
    @Autowired CustomerService customerService;
    @Autowired Printer p;
    @RequestMapping("/")  //루트 URL
    public String index() {
        p.accept("람다 이후 루트 URL 경로로 들어옴");
        
        int count = customerService.countAll();
        p.accept("람다 이후 고객의 모든인원 : " + count);
        return "index";
    }  
}
