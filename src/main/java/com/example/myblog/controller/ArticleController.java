package com.example.myblog.controller;

import com.example.myblog.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller // 컨트롤러 선언. 요청과 응답을 처리
public class ArticleController {

    @GetMapping("/articles") // 괄호 안 문자열 요청을 처리하다록 메소드 선언
    public String index(Model model){
        //key: msg, value: 안녕하세요, 반갑습니다
        model.addAttribute("msg", "안녕하세요, 반갑습니다!");
        return "articles/index"; // 뷰페이지 설정, 리턴할
    }

    @GetMapping("/articles/new") // GET 요청이 해당 url로 오면, 아래 메소드를 수행!
    public String newArticle() {
        return "articles/new"; // 보여줄 뷰 페이지
    }

    @PostMapping("/articles") // Post 방식으로 "/articles" 요청이 들어오면, 아래 메소드 수행!
    public String create(ArticleForm form) { // 폼 태그의 데이터가 ArticleForm 객체로 만들어짐!
        log.info(form.toString()); // ArticleForm 객체 정보를 확인!
        return "redirect:/articles"; // 브라우저를 "/articles" url로 보냄!
    }

}
