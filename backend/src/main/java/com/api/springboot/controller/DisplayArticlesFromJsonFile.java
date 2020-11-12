package com.api.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.business.ArticleRepository;
import com.api.springboot.models.Article;

/**
 * Spring boot restFul api controller : MVC design pattern
 * 
 * @author ibrahimabdourahmane
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/article-api/v1/")
public class DisplayArticlesFromJsonFile {

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * get all articles from the JSON file
	 * 
	 * @return array of articles
	 */
	@GetMapping("/articles")
	public List<Article> getAllArticles() {

		return articleRepository.findAllArticles();
	}

	@GetMapping("/articles/{source}")
	public List<Article> getArticleBySource(@PathVariable String source) {
		return articleRepository.findArticleBySource(source);
	}

	@GetMapping("/articles/sources")
	public Object[] getAllArticlesSources() {
		return articleRepository.findAllArticlesSourcesFromTheJsonFile();
	}

	@GetMapping("/articles/data/{region}")
	public List<Article> getArticlesByRegion(@PathVariable String region) {

		return articleRepository.findArticlesByRegion(region);
	}

	@GetMapping("/articles/themes")
	public Object[] getAllArticlesThemes() {

		return articleRepository.retreiveThemesFromArticles();
	}

	@GetMapping("/article-by-themes")
	public List<Article> getArticlesByThemes(@RequestParam(name = "themes") String themes) {

		return articleRepository.findArticlesByThemes(themes);
	}

	@GetMapping("/article")
	public Article getArticleById(@RequestParam(name = "id") String id) {

		return articleRepository.findArticleById(id);
	}

}
