package com.example.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 선언. 요청과 응답을 처리
public class ArticleController {

    @GetMapping("/articles") // 괄호 안 문자열 요청을 처리하다록 메소드 선언
    public String index(Model model){
        //key: msg, value: 안녕하세요, 반갑습니다
        model.addAttribute("msg", "안녕하세요, 반갑습니다!");
        return "articles/index"; // 뷰페이지 설정, 리턴할
    }

}
