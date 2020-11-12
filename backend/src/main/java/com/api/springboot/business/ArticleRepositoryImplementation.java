package com.api.springboot.business;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.api.springboot.models.Article;

@Repository
public class ArticleRepositoryImplementation implements ArticleRepository {

	@Override
	public List<Article> findAllArticles() {
		return ArticleUtilities.parseJsonFileAndReturnArticleList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findArticleBySource(String source) {

		List<Article> articlesList = ArticleUtilities.parseJsonFileAndReturnArticleList();

		List<Article> list = new ArrayList<Article>();

		for (Article article : articlesList) {
			if (article.getSource().equals(source)) {
				list.add(article);
			}
		}

		return list;
	}

	@Override
	public Object[] findAllArticlesSourcesFromTheJsonFile() {

		Function<Article, String> articleFunction = (Article article) -> article.getSource();

		List<Article> articlesList = ArticleUtilities.parseJsonFileAndReturnArticleList();

		return ArticleUtilities.transformArticleToStringArrayElement(articlesList, articleFunction);
	}

	@Override
	public List<Article> findArticlesByRegion(String region) {
		List<Article> articlesList = ArticleUtilities.parseJsonFileAndReturnArticleList();
		return ArticleUtilities.filterArticlesByRegion(articlesList, region);

	}

	@Override
	public Page<Object> findAllArticlesWithPagination(String keyWord, int page, int size, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] retreiveThemesFromArticles() {

		List<Article> articlesList = ArticleUtilities.parseJsonFileAndReturnArticleList();

		return ArticleUtilities.getTheme(articlesList);
	}

	@Override
	public List<Article> findArticlesByThemes(String themes) {
		List<Article> articlesList = ArticleUtilities.parseJsonFileAndReturnArticleList();
		List<Article> articles = new ArrayList<Article>();
		if (themes != null) {

			String[] themesList = themes.split(",");
			for (String theme : themesList) {

				Predicate<Article> predicate = (Article p) -> (p.getThemes()).toLowerCase()
						.contains(theme.toLowerCase());

				articlesList.stream().filter(p -> predicate.test(p)).forEach(p -> articles.add(p));

			}
			return articles;
		}

		return articlesList;
	}

	@Override
	public Article findArticleById(String id) {
		List<Article> articlesList = ArticleUtilities.parseJsonFileAndReturnArticleList();

		if (articlesList != null) {
			for (Article article : articlesList) {
				if (article.getId().equals(id)) {
					return article;
				}
			}
		}
		return null;

	}

}
