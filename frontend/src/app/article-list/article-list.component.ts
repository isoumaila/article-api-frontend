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
  endIndex = 10;

  


  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.getArtilces();

  }


  


  getArrayFromPageLength(length){
    //const lengthDevide = length/50;
    console.log(length)
    return new Array((length-7)/10);
  }

  updatePage(pageIndex){
    this.startIndex = pageIndex*50;
    this.endIndex = this.startIndex + 50;
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
