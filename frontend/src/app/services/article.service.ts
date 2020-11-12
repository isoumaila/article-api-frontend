import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../models/article';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private baseURI = "http://localhost:8081/article-api/v1";
  private articleURL = this.baseURI +"/articles";

  constructor(private httpClient: HttpClient) { }


  /**
   *  get all article from the api
   */
  getArticlesList(): Observable<Article[]>{
    return this.httpClient.get<Article[]>(`${this.articleURL}`);
  }

  /**
   *  get all article from the api by source
   */
  getArticlesListBySource(source: string): Observable<Article[]>{
    return this.httpClient.get<Article[]>(`${this.articleURL}/${source}`);
  }

  
  getAllArticlesSources():Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.articleURL}/${"sources"}`);
  }

  getAllThemes(): Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.articleURL}/${"themes"}`);
  }

  getArticlesByThemes(theme:string): Observable<Article[]>{
    return this.httpClient.get<Article[]>(`${this.baseURI}/${"article-by-themes?themes="+theme}`);
  }

  getArticle(id:string):Observable<Article>{
    return this.httpClient.get<Article>(`${this.baseURI}/${"article?id="+id}`);
  }
  
  /**
   * this method initialize an array of article object
   * @param articles array
   */
  initArticles(articles: Article[]):Article[]{
    var articlesObj: Article[] = []
  
    var index :number = 0
    for(index; index<articles.length; index++ ){
      var article = this.initArticle(articles[index]);
        articlesObj.push(article);

    }
    return articlesObj;
  }

  initArticle(data: any):Article{ 
    return new Article(
      data.title,
      data.body,
      data.publication_date, 
      data.source,
      data.edition,
      data.departements,
      data.regions
      ,data.sectors,
      data.themes,
      data.id );
  }
  
}
