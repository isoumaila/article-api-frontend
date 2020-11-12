package com.api.springboot.business;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.springboot.models.Article;

public interface ArticleRepository {

	public List<Article> findAllArticles();

	public Article findArticleById(String id);

	public List<Article> findArticleBySource(String source);

	public Object[] findAllArticlesSourcesFromTheJsonFile();

	public List<Article> findArticlesByRegion(String region);

	public Page<Object> findAllArticlesWithPagination(String keyWord, int page, int size, Pageable pageable);

	public Object[] retreiveThemesFromArticles();

	public List<Article> findArticlesByThemes(String themes);

}
