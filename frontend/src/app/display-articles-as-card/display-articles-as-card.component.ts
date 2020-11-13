import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Article } from '../models/article';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-display-articles-as-card',
  templateUrl: './display-articles-as-card.component.html',
  styleUrls: ['./display-articles-as-card.component.css']
})
export class DisplayArticlesAsCardComponent implements OnInit {


  themes: string[];
  themeKeyWord: string = "Dévelo";
  articles: Article[];

  constructor(private articleService: ArticleService, private _route: Router) { }



  ngOnInit(): void {

    this.getArticlesBySource();
    this.getArticlesByThemes();
    console.log(this.articles)
  }

  getArticlesBySource() {
    this.articleService.getAllThemes().subscribe(
      data => {
        this.themes = data;

      }
    );
  }


  getArticlesByThemes() {
    this.articleService.getArticlesByThemes(this.themeKeyWord).subscribe(
      data => {
        this.articles = data;
      }
    )
  }

  onClick(id: string) {
    console.log(id)
    this._route.navigate(['/article', id]);

  }

  filterByTheme(theme:string){
    this.articleService.getArticlesByThemes(theme).subscribe(
      data => {
        this.articles = data;
      }
    )
  }
}
