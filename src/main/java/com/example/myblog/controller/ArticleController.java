package com.example.myblog.controller;


import com.example.myblog.dto.ArticleForm;
import com.example.myblog.entity.Article;
import com.example.myblog.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 컨트롤러 선언
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {

    @Autowired //스프링부트가 미리 만든 객체를 가져와 연결한다. 그래서 new 로 생상하지 않아도 된다.
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    
    @PostMapping("/articles/create")//폼에서 action으로 주는 주소
    public String createAticles(ArticleForm form){
        //System.out.println(form.toString()); -> 로깅 기능 남기기
        log.info(form.toString());


        //DTO form을 Entity article로 바꾼다
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        //Repository에게 Entity를 디비에 저장하게 한다다
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }
}
