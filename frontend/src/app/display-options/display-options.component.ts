import { Component, OnInit } from '@angular/core';
import { Article } from '../models/article';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-display-options',
  templateUrl: './display-options.component.html',
  styleUrls: ['./display-options.component.css']
})
export class DisplayOptionsComponent implements OnInit {

  articles : Article[]=[]
  sources: string[]
  source: string = "ff"
  articlesObj: Article[]=[]


  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.getAllArticlesSources();
  }



  getArticlesBySource(){
    this.articleService.getArticlesListBySource(this.source).subscribe(
      data => {
        this.articles = data;
        this.articlesObj = this.articleService.initArticles(this.articles);
      }
    );
  }



  getAllArticlesSources(){
    this.articleService.getAllArticlesSources().subscribe(
      data => {
        this.sources = data;
      }
    )
  }

  onSearch(){
    
    this.getArticlesBySource();
    
    
  }
}
