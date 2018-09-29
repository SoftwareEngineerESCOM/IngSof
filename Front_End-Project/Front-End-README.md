# Angular Project 

This is the Front-End Project. Here is placed all files related to the Angular app

## Relevant project files

 - [App Module](https://github.com/SoftwareEngineerESCOM/IngSof/blob/Desarrollo-Front/Front_End-Project/src/app/app.module.ts) : Here goes the modules used in the project also the routering.
 - [Global Styles](https://github.com/SoftwareEngineerESCOM/IngSof/blob/Desarrollo-Front/Front_End-Project/src/styles.css) : Here goes the styles that are going to be applied to whole project.

## Routing
In order to add more routes to the app, pleasse modify the code below in the following file [App Module](https://github.com/SoftwareEngineerESCOM/IngSof/blob/Desarrollo-Front/Front_End-Project/src/app/app.module.ts):

    ...
    const routes: Routes = [
      {path: 'Index', component: IndexComponent},
      //add more paths in the same style, the routes order matter
      {path: '', redirectTo: '/Index', pathMatch: 'full'},
      {path: '**', component: PageNotFoundComponent}
    ];
    ...

