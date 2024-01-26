package me.junhojung.springbootdeveloper.controller;


import lombok.RequiredArgsConstructor;
import me.junhojung.springbootdeveloper.domain.Article;
import me.junhojung.springbootdeveloper.dto.ArticleListViewResponse;
import me.junhojung.springbootdeveloper.dto.ArticleViewResponse;
import me.junhojung.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.finById(id);

        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }
}
