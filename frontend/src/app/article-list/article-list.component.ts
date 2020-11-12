import { Component, OnInit } from '@angular/core';
import { Article } from '../models/article';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  articles : Article[]=[]
  articlesObj: Article[]=[]
  filteredArticles: Article[]=[]

  startIndex = 0;
  endIndex = 2;

  private _searchTerm: string;

 get searchTerm(): string {
    return this._searchTerm;
  }

  set searchTerm(value: string) {
    this._searchTerm = value;
    this.filteredArticles = this.filterArticles(value);
  }


  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.getArtilces();

  }


  filterArticles(searchString: string) {
    return this.articlesObj.filter(article =>
      article.title.toLowerCase().indexOf(searchString.toLowerCase()) !== -1);
  }


  getArrayFromPageLength(length){
    return new Array(length);
  }

  updatePage(pageIndex){
    this.startIndex = pageIndex*2;
    this.endIndex = this.startIndex + 2;
  }
  getArtilces(){
    this.articleService.getArticlesList().subscribe(
      data => {
        this.articles = data;
        this.articlesObj = this.articleService.initArticles(this.articles);
      }
    );

    
  }

}
