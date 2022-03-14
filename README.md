# Advice.me 

# Phase 0

## Members 
| Name                      | e-mail                            | GitHub username |
| ------------------------- | --------------------------------- | --------------- |
| María Esteban Sánchez     | m.esteban.2019@alumnos.urjc.es    | Maria-ES        | 
| Miguel Regato Herrero     | m.regato.2019@alumnos.urjc.es     | MiguelRegato    | 
| Juan Carlos Moreno García | jc.moreno.2019@alumnos.urjc.es    | JuanCarlos-URJC |  
| Héctor Fernández Martínez | h.fernandezm.2019@alumnos.urjc.es | HectorURJC      | 
| Vanesa Reina Hernández    | v.reina.2019@alumnos.urjc.es      | vanesa-rh       | 

 

## Entities

### Users: 

* **Anonymous**: This type of users will be able to see the assessments about films of the web page. However, they will not be able to contribute adding their own assessments and will not receive recommendations. 

* **Registered**: They will be able to receive recommendations, assess/rate films of the web page, follow other users and see their commented films.  

* **Admin**: They will be able to add/delete and edit films and delete assessments of the web page. 

 

### Assessments:  

Users can assess and rate films. 

 

### Films:  

Users will be able to see the description and assessments of any film. 

 

### Recommendations:  

Users can receive recommendations of films and their assessments. 

 

## User permissions 

Users can write an assessment about a film, having also to rate it. They can modify their assessments at any moment. 

 

## Pictures

The entity ‘Users’ may have one profile picture, as well as the entity ‘Films’. 

 

## Charts

There will be a pie chart representing the most valued genders of films. 

 

## Complementary Technology

The web page will send emails to users notifying them about new recommendations. 

 

## Algorithm

Search films by title and sort by ratings from highest to lowest. Furthermore, the application will show films suggested based on user comments/ratings.

# Phase 1

## Web pages layout using HTML and CSS

### Unregistered users 

**Initial menu:** 
First screen of the webpage that contains a list of films splitted by genre and a pie chart that informs the most famous film genres of Advice.me. 
 
![avatar](ImagesPhase2/adviceMe.png) 
 
**Login:** 
Screen that will allow registered users to log in giving their email and password. All users have access to this screen even though only registered users will be able to end this process. 
 
![avatar](ImagesPhase2/Login.png) 

 **Login error:** 
Screen that will appear when the user is trying to login and he writes his credentials wrong. 

![avatar](ImagesPhase2/ErrorLogin.png) 

**Register:** 
Screen that will allow new users to sing up in Advice.me and access exclusive content and services. 
 
![avatar](ImagesPhase2/Register.png) 

**Taken User Name:** 
Screen that will apear when he tries to register with a nickname that is already taken. 

![avatar](ImagesPhase2/TakenUserName.png) 

**Film description:** 
Screen that will display information, image and assessments about the film. Also, at the bottom of the page related films will appear. 
 
![avatar](ImagesPhase2/FilmUnregistered.png) 

**Search film:** 
Screen that will display the films that contains the words that you searched. 
 
![avatar](ImagesPhase2/SearchFilms.png) 

### Registered users 

**Initial menu:** 
First screen of the webpage that contains a list of films splitted by genre and a circle graph that informs the most famous film genres of Advice.me. Moreover, this screen will have personaliced recomendations for the user and access to their account. 
 
![avatar](ImagesPhase2/MenuRegistered.png) 

**Profile:** 
Screen that will display the users information and profile picture. Also they will be able to access the modification profile information and change their profile picture. 
 
![avatar](ImagesPhase2/Profile.png) 

**Edit profile:** 
Screen that will allow the user to  modify their information. 
 
![avatar](ImagesPhase2/EditProfile.png) 

**Change password:** 
Screen that will allow the user to change his password. 

![avatar](ImagesPhase2/ChangePassword.png) 

**Error old password:** 
Screen that will appear when the user is trying to change the password and writes his old password wrong.  

![avatar](ImagesPhase2/ErrorOldPassword.png) 

**Film description:** 
Screen that will display information, images and assessments about the film. Also, at the bottom of the page related films will appear. Registered users can add an assessment to the film if they did not do it before. 
 
![avatar](ImagesPhase2/FilmRegistered.png) 

**Add comment:** 
Screen that will allow the user to upload a comment writing his opinion and adding a rating of the film. 

![avatar](ImagesPhase2/AddComment.png) 

**Edit comment:** 
Screen that will allow the user to modify their comments. 

![avatar](ImagesPhase2/EditComment.png) 

**Watch profile:** 
Screen that will allow the user to watch others profiles without the edit profile and the remove/edit comments buttons. Also the user can follow the other user with a button. 

![avatar](ImagesPhase2/WatchProfile.png) 

**Followers:** 
Screen that will allow the user to watch the users who follow him. 

![avatar](ImagesPhase2/Followers.png) 

**Following:** 
Screen that will allow the user to watch the users you follow. 

![avatar](ImagesPhase2/Following.png) 

**Search films:** 
Screen that will allow the user to watch a list of films that contains a certain word/words in their tittle. 

![avatar](ImagesPhase2/SearchFilmRegistered.png) 

### Admin 

**Initial menu:** 
First screen of the webpage that contains a list of films splitted by genre and a circle graph that informs the most famous film genres of Advice.me. Admins will have access to the "Post film" button. 
 
![avatar](ImagesPhase2/MenuAdmin.png) 

**Add film:** 
Screen that will allow admins to add films to the database. 
 
![avatar](ImagesPhase2/AddFilm.png) 

**Film description:** 
Screen that will display information, images and assessments about the film. Admins can eliminate the film and its assesments. Also, admins will be able to enter in the edit film page. 
 
![avatar](ImagesPhase2/FilmAdmin.png) 

**Edit film:** 
Screen that will allow admins to edit the information from any film and save it in the database. 
 
![avatar](ImagesPhase2/EditFilm.png)

**Search films:** 
Screen that will allow the user to watch a list of films that contains a certain word/words in their tittle. 
 
![avatar](ImagesPhase2/SearchFilmAdmin.png)

## Navigation Diagram
* Blue = Unregistered users.
* Yellow = Registered users.
* Green = Admins.
* Red = Error pages.

![diagram](ImagesPhase2/NavigationDiagram.png)


# Phase 2
## Database Entity Diagram

![diagram](ImagesPhase2/DatabaseEntityDiagram.png)

## UML Java Classes Diagram

![diagram](ImagesPhase2/UMLJavaClassesDiagram.png)

## Classes and Templates Diagram

![diagram](ImagesPhase2/ClassesAndTemplatesDiagram.png)

## Execute instructions
In order to install this application you should follow the next steps:
1.	Download as a .zip the proyect from the main branch of this repository: https://github.com/CodeURJC-DAW-2021-22/webapp1.git
2.	Extract the .zip and save it in your computer.
3.	Open SpringToolSuite4 and open the backend proyect contained in the webapp1-main directory.
4.	Using pgAdmin 4 from PostgreeSQL create a database in your local server with the name "AdviceMe" 
5.	Run the application in SpringToolSuite4.
6.	Go to your preferred browser and go to: https://localhost:8443 and enjoy the application.

Requirements:
* 	Java version 17.
*	PostGreeSQL 14.
*	Maven 4.0.0.
*	Spring boot 2.6.3.
*	Javax.mail version 1.6.2.
*	JQuery 3.5.1.
*	Bootstrap 5.0.2.

## Group members participation

### María Esteban Sánchez
#### Textual description:
Maria created the add comment and save it in database funcion and page asociated, as well as create user, save it in database and show their information on profile. Also, linked profile with comments from a film and with the user who makes the comment and optimiced the plugin "rateyo".

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Function of register and showing the info 	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/6c86f9aba67c4a4ed154a9e26d9eb5718b3f90b1 | 
| #2            | Function of adding a comment to a film	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/a0901df6ec5bad9f4c83c2b90d7b8bcf0a2afedf | 
| #3            | Linked commets and user when save it		   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/ed676a017562a40195b1e0228b22dd6e889cd710 | 
| #4            | Fixed rateyo plug in to show the asserts	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/1b9ea8bb73ac0c610a708bfe82bc1a30b8272df8 |
| #5            | Implemented function to follow		   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/7cc39a440cb6375edde798181bc3cddf94ae9fad |


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [Comment.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/model/Comment.java)     | 
| #2            | [UserController.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/UserController.java)     | 
| #3            | [DatabaseInitializer.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/service/DatabaseInitializer.java)     | 
| #4            | [User.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/model/User.java)     | 
| #5            | [UserService.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/service/UserService.java)     | 


### Miguel Regato Herrero
#### Textual description:
Miguel implemented the edit profile, the function of changing the profile photo and the function of removing and editing comments for users. He also made the pages where you can watch your following users and followers. He implemented the function that the user can only comment once in the same film.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Remove and edit comments			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/9958f47f35e2579559d50c62fe22ab4653471a12 | 
| #2            | Following and followers page			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/e3376cab9959e00255dabed87dc5f8f7e6429acd | 
| #3            | Edit profile functionality			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/d95f1c87870b28ec0bbed07e27c8743d37579d00 | 
| #4            | The user can only make one comment in the film   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/816ab5975f9c6c7c178cc253c1af77a46a295071 | 
| #5            | Function implemented to change the profile photo | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/4f505df3f62938f53d5733181cf0ffd73d6b51c1 |


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [Profile](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/templates/profile.html)     | 
| #2            | [EditProfile](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/templates/editProfile.html)     | 
| #3            | [Followers](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/templates/followers.html)     | 
| #4            | [Following](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/templates/following.html)     | 
| #5            | [UserController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/UserController.java)     | 


### Juan Carlos Moreno García
#### Textual description:
Juan Carlos made the seach film function as well as the html page for it, optimiced code deleting unnecesary parts and refactored all the classes.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | ************************************************ | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/**************************************** | 
| #2            | ************************************************ | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/**************************************** | 
| #3            | ************************************************ | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/**************************************** | 
| #4            | ************************************************ | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/**************************************** | 
| #5            | ************************************************ | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/**************************************** |


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [nombre](link)     | 
| #2            | [nombre](link)     | 
| #3            | [nombre](link)     | 
| #4            | [nombre](link)     | 
| #5            | [nombre](link)     | 


### Héctor Fernández Martínez
#### Textual description:
Héctor was in charge of the security of the application as well as the implemmentation of the additional technology (send emails). He made the login function, the error page and the functionality of changing the password.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Final version of security in html	           | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/1256c10f08aa4d92746ee84b75fc5a1ba0a19018 | 
| #2            | Final version of send email			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/4bed499e0d5f51b5b47a1f297e081e9fd69187fa | 
| #3            | Final version of error page in html		   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/94c2567b35a16e9aaa5c03318dacbfe82655860b | 
| #4            | Final version of login			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/1256c10f08aa4d92746ee84b75fc5a1ba0a19018 | 
| #5            | Final version of change password		   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/604697df5021f4bc7beec0aaf68da2df047fe22c |


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [editPassword.html](backend/src/main/java/app/controller/IndexController.java)     | 
| #2            | [login.html](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/templates/login.html)     | 
| #3            | [WebSecurityConfig.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/security/WebSecurityConfig.java)     | 
| #4            | [IndexController.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/IndexController.java)     | 
| #5            | [SendMail.java](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/service/SendMail.java)     | 


### Vanesa Reina Hernández
#### Textual description:
Vanesa was in charge of the transition from H2 database to PostGreeSQL. She created the principal structures for the database (some entities, repositories and services), transformed the statics htmls pages to a linked aplication. Also, she made the add, edit and delete film functions. She transformed the menu htmls to show the database films, as well as the showFilms of every user. Moreover, she created the edit film page and the load "More x" buttons with spinner and ajax call of the application.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Final version of loading more films button       | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/e03187cc52bc913a29a5d47f283782e2fc6319ab | 
| #2            | Final version of delete and edit film            | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/8ae8afd494cdda0f6372850d87342a184e2390ab | 
| #3            | Final version of add film to database and images | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/07ba00581c4bb1e55787dca9aa9653dae83171cb | 
| #4            | Film database and linked pages to visualice them | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/f247cd46bb803f61d2a5c7df8e96fb310acc4833 | 
| #5            | Final version of loading more comments, films and search button | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/d35640e112da4c1279351d5658fa0a8634f4c5ba | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [LoadButton](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/static/loadButton.js)     | 
| #2            | [DatabaseInitializer](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/service/DatabaseInitializer.java)     | 
| #3            | [FilmService](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/service/FilmService.java)     | 
| #4            | [AjaxController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/AjaxController.java)     | 
| #5            | [AdviceMe](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/templates/adviceMe.html)     | 
