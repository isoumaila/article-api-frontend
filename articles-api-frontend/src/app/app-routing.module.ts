import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleComponent } from './article/article.component';
import { DisplayArticlesAsCardComponent } from './display-articles-as-card/display-articles-as-card.component';
import { DisplayOptionsComponent } from './display-options/display-options.component';


const routes: Routes = [
  {path: 'articles', component: ArticleListComponent},
  {path: 'article/:id', component: ArticleComponent},
  {path: 'options', component: DisplayOptionsComponent},
  {path: 'display-2', component: DisplayArticlesAsCardComponent},
  {path: '', redirectTo: 'articles', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
