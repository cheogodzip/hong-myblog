package com.example.myblog.controller;


import com.example.myblog.dto.ArticleForm;
import com.example.myblog.entity.Article;
import com.example.myblog.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id: " + id);

        //1. id로 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //id 값을 통해 찾았는데 값이 없다면 null을 반환해라 라는 뜻

        //2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);


        //3. 보여줄 페이지 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1. 모든 article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        //2. 가져온 아티클 묶음을 뷰로 전달한다.
        model.addAttribute("articleList", articleEntityList);

        //3. 뷰페이지 설정
        return "articles/index";
    }
}
