import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from '../models/article';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {


  article : Article
  constructor(private articleService: ArticleService,private  route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.getArticle(id);

    

  }



  getArticle(id:string){
      this.articleService.getArticle(id).subscribe(
        data => {
          this.article = this.articleService.initArticle(data);
          console.log(this.article)
         
        }
      )
  }

  goBackToArticles(){
    //this.route.navigate(['/families']);
   
  }

}
