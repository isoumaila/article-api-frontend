export class Article {


    title: String;
    body: string;
    publication_date : Date;
   
    source: string;
    edition: string;
    departements: string;
    regions: string;
    sectors: string;
    themes: string;
    themeArray: string[]
    sectorsArray: string[]
    id : string

    

    constructor(title: String,body: string,publication_date:Date, source: string, edition: string, departements: string,
        regions: string,sectors: string,themes: string, id : string) { 
        this.title = title;
        this.body = body;
        this.publication_date = new Date (publication_date) ;
        this.source =source
        this.edition = edition;
        this.departements = departements;
        this.regions = regions;
        this.sectors = sectors;
        this.themes = themes;
        this.themeArray = themes.split(",");
        this.sectorsArray = sectors.split(",");
        this.id = id;
        

     }  

}
