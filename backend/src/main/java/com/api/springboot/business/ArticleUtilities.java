package com.api.springboot.business;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.api.springboot.models.Article;

public class ArticleUtilities {

	public ArticleUtilities() {
		super();
	}

	@SuppressWarnings("unchecked")
	public static JSONArray parseFile() {

		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(".//jsonfiles//site_articles.json")) {

			Object jsonObj = jsonParser.parse(reader);

			JSONArray articleList = (JSONArray) jsonObj;

			return articleList;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Article> parseJsonFileAndReturnArticleList() {

		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(".//jsonfiles//site_articles.json")) {

			Object jsonObj = jsonParser.parse(reader);

			JSONArray jsonArray = (JSONArray) jsonObj;

			List<Article> articleList = new ArrayList<Article>();

			if (jsonArray != null) {
				jsonArray.forEach(article -> articleList.add(parsearticleObject((JSONObject) article)));
			}

			return articleList;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Article parsearticleObject(JSONObject articleData) {

		Article article = new Article();

		String title = (String) articleData.get("titre");
		String body = (String) articleData.get("corps");
		String publication_date = (String) articleData.get("publication_date");
		String source = (String) articleData.get("source");
		String edition = (String) articleData.get("edition");
		String departements = (String) articleData.get("departements");
		String regions = (String) articleData.get("regions");
		String sectors = (String) articleData.get("secteurs");
		String themes = (String) articleData.get("themes");

		article.setTitle(title);
		article.setBody(body);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			article.setPublication_date(format.parse(publication_date));
		} catch (java.text.ParseException e) {
			System.out.print("Date of the publication is wrong for this artilce : " + title);
			e.printStackTrace();
		}
		article.setSource(source);
		article.setEdition(edition);
		article.setDepartements(departements);
		article.setRegions(regions);
		article.setSectors(sectors);
		article.setThemes(themes);
		article.generateId();

		if (title != null && body != null && publication_date != null && source != null && edition != null
				&& departements != null && regions != null && sectors != null) {
			return article;
		}
		return null;
	}

	/**
	 * return string array of article object
	 * 
	 * @param listArticle
	 * @param funcArticle
	 * @return StringArray
	 */
	@SuppressWarnings("unchecked")
	public static Object[] transformArticleToStringArrayElement(List<Article> listArticle,
			Function<Article, String> funcArticle) {
		List<String> stringArray = new ArrayList<>();
		listArticle.forEach(article -> stringArray.add(funcArticle.apply(article)));

		return stringArray.stream().distinct().toArray();
	}

	/**
	 * filer article list by region
	 * 
	 * @param listArticle
	 * @param keyWord
	 * 
	 * @return array of articles
	 */
	@SuppressWarnings("unchecked")
	public static List<Article> filterArticlesByRegion(List<Article> listArticle, String region) {
		List<Article> articles = new ArrayList<Article>();
		Predicate<Article> predicate = (Article p) -> (p.getRegions()).toLowerCase().equals(region.toLowerCase());
		if (listArticle != null && region != null) {

			listArticle.stream().filter(p -> predicate.test(p)).forEach(p -> articles.add(p));
			return articles;
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public static List<Article> filterArticlesByKeyWorkFromTheTitle(List<Article> listArticle, String keyWord) {
		List<Article> articles = new ArrayList<Article>();
		Predicate<Article> predicate = (Article p) -> (p.getTitle()).toLowerCase().contains(keyWord.toLowerCase());
		if (listArticle != null && keyWord != null) {

			listArticle.stream().filter(p -> predicate.test(p)).forEach(p -> articles.add(p));
			return articles;
		}
		return null;

	}

	public static Object[] getTheme(List<Article> listArticle) {

		List<String> listeOfTheme = new ArrayList<String>();
		for (Article article : listArticle) {
			String[] theme = article.getThemes().split(",");

			listeOfTheme.addAll(Arrays.asList(theme));

		}

		return listeOfTheme.stream().distinct().sorted().toArray();

	}

}
