package com.api.springboot.models;

import java.util.Date;

public class Article {

	private String title;
	private String body;
	private Date publication_date;
	private String source;
	private String edition;
	private String departements;
	private String regions;
	private String sectors;
	private String themes;
	private String id;

	public Article(String title, String body, Date publication_date, String source, String edition, String departements,
			String regions, String sectors, String themes) {
		super();
		this.title = title;
		this.body = body;
		this.publication_date = publication_date;
		this.source = source;
		this.edition = edition;
		this.departements = departements;
		this.regions = regions;
		this.sectors = sectors;
		this.themes = themes;
		this.generateId();
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(Date date) {
		this.publication_date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getDepartements() {
		return departements;
	}

	public void setDepartements(String departements) {
		this.departements = departements;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	public String getSectors() {
		return sectors;
	}

	public void setSectors(String sectors) {
		this.sectors = sectors;
	}

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void generateId() {

		this.id = this.title + this.edition + this.departements + this.themes + this.publication_date.toString();
		this.id = this.id.replace(" ", "").replaceAll("[^a-zA-Z0-9]+", "");
	}

}
