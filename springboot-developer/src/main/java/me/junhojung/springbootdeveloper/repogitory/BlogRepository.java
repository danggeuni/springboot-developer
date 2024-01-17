package me.junhojung.springbootdeveloper.repogitory;

import me.junhojung.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
