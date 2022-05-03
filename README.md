# Advice.me 

**Video**: https://www.youtube.com/watch?v=Dg0di2HXpzY

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
 
![avatar](ImagesPhase3/adviceMe.png) 
 
**Login:** 
Screen that will allow registered users to log in giving their email and password. All users have access to this screen even though only registered users will be able to end this process. 
 
![avatar](ImagesPhase3/Login.png) 

 **Login error:** 
Screen that will appear when the user is trying to login and he writes his credentials wrong. 

![avatar](ImagesPhase3/ErrorLogin.png) 

**Register:** 
Screen that will allow new users to sing up in Advice.me and access exclusive content and services. 
 
![avatar](ImagesPhase3/Register.png) 

**Taken User Name:** 
Screen that will apear when he tries to register with a nickname that is already taken. 

![avatar](ImagesPhase3/TakenUserName.png) 

**Film description:** 
Screen that will display information, image and assessments about the film. Also, at the bottom of the page related films will appear. 
 
![avatar](ImagesPhase3/FilmUnregistered.png) 

**Search film:** 
Screen that will display the films that contains the words that you searched. 
 
![avatar](ImagesPhase3/SearchFilms.png) 

### Registered users 

**Initial menu:** 
First screen of the webpage that contains a list of films splitted by genre and a circle graph that informs the most famous film genres of Advice.me. Moreover, this screen will have personaliced recomendations for the user and access to their account. 
 
![avatar](ImagesPhase3/MenuRegistered.png) 

**Profile:** 
Screen that will display the users information and profile picture. Also they will be able to access the modification profile information and change their profile picture. 
 
![avatar](ImagesPhase3/Profile.png) 

**Edit profile:** 
Screen that will allow the user to  modify their information. 
 
![avatar](ImagesPhase3/EditProfile.png) 

**Change password:** 
Screen that will allow the user to change his password. 

![avatar](ImagesPhase3/ChangePassword.png) 

**Error old password:** 
Screen that will appear when the user is trying to change the password and writes his old password wrong.  

![avatar](ImagesPhase3/ErrorOldPassword.png) 

**Film description:** 
Screen that will display information, images and assessments about the film. Also, at the bottom of the page related films will appear. Registered users can add an assessment to the film if they did not do it before. 
 
![avatar](ImagesPhase3/FilmRegistered.png) 

**Add comment:** 
Screen that will allow the user to upload a comment writing his opinion and adding a rating of the film. 

![avatar](ImagesPhase3/AddComment.png) 

**Edit comment:** 
Screen that will allow the user to modify their comments. 

![avatar](ImagesPhase3/EditComment.png) 

**Watch profile:** 
Screen that will allow the user to watch others profiles without the edit profile and the remove/edit comments buttons. Also the user can follow the other user with a button. 

![avatar](ImagesPhase3/WatchProfile.png) 

**Followers:** 
Screen that will allow the user to watch the users who follow him. 

![avatar](ImagesPhase3/Followers.png) 

**Following:** 
Screen that will allow the user to watch the users you follow. 

![avatar](ImagesPhase3/Following.png) 

**Search films:** 
Screen that will allow the user to watch a list of films that contains a certain word/words in their tittle. 

![avatar](ImagesPhase3/SearchFilmRegistered.png) 

### Admin 

**Initial menu:** 
First screen of the webpage that contains a list of films splitted by genre and a circle graph that informs the most famous film genres of Advice.me. Admins will have access to the "Post film" button. 
 
![avatar](ImagesPhase3/MenuAdmin.png) 

**Add film:** 
Screen that will allow admins to add films to the database. 
 
![avatar](ImagesPhase3/AddFilm.png) 

**Film description:** 
Screen that will display information, images and assessments about the film. Admins can eliminate the film and its assesments. Also, admins will be able to enter in the edit film page. 
 
![avatar](ImagesPhase3/FilmAdmin.png) 

**Edit film:** 
Screen that will allow admins to edit the information from any film and save it in the database. 
 
![avatar](ImagesPhase3/EditFilm.png)

**Search films:** 
Screen that will allow the user to watch a list of films that contains a certain word/words in their tittle. 
 
![avatar](ImagesPhase3/SearchFilmAdmin.png)

## Navigation Diagram
* Blue = Unregistered users.
* Yellow = Registered users.
* Green = Admins.
* Red = Error pages.

![diagram](ImagesPhase3/NavigationDiagram.png)


# Phase 2
## Database Entity Diagram

![diagram](ImagesPhase3/DatabaseEntityDiagram.png)

## UML Java Classes Diagram

![diagram](ImagesPhase3/UMLJavaClassesDiagram.png)

## Classes and Templates Diagram

![diagram](ImagesPhase3/ClassesAndTemplatesDiagram.png)

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
Juan Carlos made the search film function as well as the html page for it, optimiced code deleting unnecesary parts and refactored all the classes. Moreover, he implemented the pie chart, based on the data from the database, the recommendations in order to send them to the users when they assest a film, and fixed other small bugs.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Refactoring and organizing code. Solving several important bugs | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/550dff3142e8ce9bba9ee48fd67f0ff7b48e2f8c | 
| #2            | Searcher implemented | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/5c22ac20dac0e3694783086678b3350c93ba030d | 
| #3            | Pie chart implemented | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/83640ed81df12fa0ee0350236f037c1425fa04f0 | 
| #4            | Recommendations implemented | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/d7ba175c869a6ca26ad5a128b3ac0b42b10ccfc5 | 
| #5            | Order films by averageStars and more films section with different films | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/09f587adc428f5386633d01b943decc7aedaf19c |


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [FilmController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/FilmController.java)     | 
| #2            | [WebSecurityConfig](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/security/WebSecurityConfig.java)     | 
| #3            | [FilmService](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/service/FilmService.java)     | 
| #4            | [Recommendation](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/model/Recommendation.java)     | 
| #5            | [ChartController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/ChartController.java)     | 


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


# Phase 3
## App deployed on Heroku

https://codeurjc-daw-2021-22-webapp1.herokuapp.com/

### Example users credentials

**Username**: user  -  **Password**: pass.

**Username**: admin  -  **Password**: adminpass.

## API REST Documentation

https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/api-docs/api-docs.yaml

https://raw.githack.com/CodeURJC-DAW-2021-22/webapp1/main/backend/api-docs/api-docs.html

## Instructions for executing the dockerized app
In order to execute the dockerized app you should follow the next steps:
1.	Install Docker Desktop.
2.	Open any shell of type "bash".
3.	Clone this repository using the command "git clone https://github.com/CodeURJC-DAW-2021-22/webapp1.git".
4.	Use command "cd" until you get to the folder "Docker".
5.	Execute the command "docker-compose up" on the shell.
6.	When the app is running, open any browser and search "https://localhost:8443".

## Instructions for constructing the docker image
In order to create the docker image you should follow the next steps:
1.	Install Docker Desktop.
2.	Create and account on Dockerhub.
3.	Open any shell of type "bash".
4.	Clone this repository using the command "git clone https://github.com/CodeURJC-DAW-2021-22/webapp1.git".
5.	Use command "cd" until you get to the folder "Docker".
6.	Execute the command "./create_image.sh DockerhubUsername/codeurjc-daw-2021-22-webapp1".

## Instructions for deploying the app on Heroku
In order to deploy the app on Heroku you should follow the next steps:
1.	Create an account on Heroku.
2.	Install Heroku package.
3.	Install maven.
4.	Open any shell of type "bash".
5.	Login on Heroku using the command "heroku login".
6.	Use command "cd" until you get to the folder "Docker".
7.	Execute the command "./create_heroku_app.sh codeurjc-daw-2021-22-webapp1".
8.	Execute the command "./deploy_heroku_app.sh codeurjc-daw-2021-22-webapp1".
9.	Open your Heroku dashboard, click on the new repository and then click on "Open App".

## Group members participation
### María Esteban Sánchez
#### Textual description:
María had created some functions for the different RestControllers, the SecurityRestController and participated in IndexRestController. She also made some postman methods, the class of FilmsList and the ApiRest documentation.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Methods of SecurityRestController		   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/4135f874ad514b258a56233b75e5c3d96977a74f | 
| #2            | Method moreCommentsProfile in AjaxRestController | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/a87a1a1669ab0da400fd4331b4c55708ed08f12c | 
| #3            | Methods of IndexRestController and class FilmsList| https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/843ad983a51d47de649c3e7d8dd06957d1bd13ed | 
| #4            | Methods in postman for IndexRestController	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/fb700b9f2fe3741d7295a3389e85a52ceb92d7c6 | 
| #5            | ApiRest Documentation				   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/efc35fe510e348cfa63c9af046cdb60af337824b | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [SecurityRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/security/RestSecurityConfig.java)     | 
| #2            | [IndexRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/IndexRestController.java)     | 
| #3            | [FilmsList](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/model/modelRest/FilmsList.java)     | 
| #4            | [AjaxRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/AjaxRestController.java)     | 
| #5            | [Postman](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/AdviceMe.postman_collection.json)     | 

### Miguel Regato Herrero
#### Textual description:
Miguel made the userRestController and some functions of the AjaxRestController and IndexRestController. He alse made the postman methods of IndexRestController and updated the pom file with the new requirements.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Methods of UserRestController			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/e53b2a97465a0593d184ad9e3d0e3f354fdc3efa | 
| #2            | Method moreCommentsWatchProfile in AjaxRestController | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/9f08af19d9669123998e8423d4a98749886d99fd | 
| #3            | Method menuAdmin in IndexRestController	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/7e5adcdac87510f7ecef73750704bfe83342b7db | 
| #4            | Methods in postman for IndexRestController	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/684becbaf630fe4c086af2a65c7a787633fb34f1 | 
| #5            | Pom modified					   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/e0de7b9dabb0752e0bd0c452204e1f454aa0231d | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [UserRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/UserRestController.java)     | 
| #2            | [IndexRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/IndexRestController.java)     | 
| #3            | [Postman](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/AdviceMe.postman_collection.json)     | 
| #4            | [AjaxRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/AjaxRestController.java)     | 
| #5            | [Pom](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/pom.xml)     | 


### Juan Carlos Moreno García
#### Textual description:
Juan Carlos was in charge of creating the Docker image, Docker compose and deploying the app in Heroku. Also, he fixed problems of the application and implemented some functions of the different RestControllers.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | docker-compose.yml and deploy_heroku_app.sh | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/c861ba77a292f01d6a36ca4013b95f302e10def8 | 
| #2            | removeComment and important changes were made in restController module | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/84b5d839a9201ed218695f077e1984210ce0dc8c | 
| #3            | Names for api rest method changed and some extra changes | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/c123e550be973c494e131a8ec517260a96dd9da8 | 
| #4            | Repeated methods moved to service layer | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/5fee948ab5088708808413e7fc916921eb31dbb4 | 
| #5            | Important bugs fixed| https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/db05d0a692be45b24cd48c36e302bb92c715b9b1 | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [docker (docker-compose and deploy_heroku_app.sh)](https://github.com/CodeURJC-DAW-2021-22/webapp1/tree/main/docker)     | 
| #2            | [FilmRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/FilmRestController.java)     | 
| #3            | [CommentRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/CommentRestController.java)     | 
| #4            | [UserRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/UserRestController.java)     | 
| #5            | [Postman](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/AdviceMe.postman_collection.json)     | 


### Héctor Fernández Martínez
#### Textual description:
Héctor was in charge of creating the Docker image, Docker compose and deploying the app in Heroku. Also, he made the security and login of the API REST, some functions of RestController, specially IndexRestController, and creation of api-docs.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Dockerfile, create_image.sh and create_heroku_app.sh| https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/7d7d078b916355f4a3cd4167be8294dc6682e665 | 
| #2            | Security of RestSecurityConfig		   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/f75f53e46c7e84e6ef1e202677610bac29071744 | 
| #3            | Create LoginRestController			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/c1a2fea18a07c2056593c0cf645f333a5fa71916 | 
| #4            | More attributes of Application.properties	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/0451a796f40615f9f341ef8277172b602aaf3084 | 
| #5            | Functions of IndexRestController		   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/38e14d93976f37cf41340b72e7b6a4ed40262793 | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [RestSecurityConfig](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/security/RestSecurityConfig.java)     | 
| #2            | [docker (Dockerfile, create_image.sh and create_heroku_app.sh)](https://github.com/CodeURJC-DAW-2021-22/webapp1/tree/main/docker)     | 
| #3            | [LoginRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/auth/LoginRestController.java)     | 
| #4            | [Application.properties](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/resources/application.properties)     | 
| #5            | [IndexRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/IndexRestController.java)     | 

### Vanesa Reina Hernández
#### Textual description:
Vanesa was the responsible of the most part of AjaxRestController and FilmRestController. She created the functions of postman of those RestControllers, as well as two functions for UserRestController and CommentRestController.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Postman json for AjaxRest and FilmRest	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/cf7edb584cca450cddfa350fcd743771a0af03ee | 
| #2            | AjaxRestController most functions impplemented   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/61df85507e9b32c3abaa39850c200e215ab66e8f | 
| #3            | AddComment function for CommentsRestController | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/d0ee94dd7b9b8d184d3cd6b7b2c1d8a813a76d0a | 
| #4            | FilmRestController functions | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/d99a8d7494135763cd2f0ba6a45ae64157a734ae | 
| #5            | FilmRest functions				   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/2d0df9ca5b8e3a7996b661cf4128b71adb4110bb | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [Postman](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/AdviceMe.postman_collection.json)     | 
| #2            | [CommentRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/CommentRestController.java)     | 
| #3            | [FilmRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/FilmRestController.java)     | 
| #4            | [AjaxRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/AjaxRestController.java)     | 
| #5            | [UserRestController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/restController/UserRestController.java)     | 


# Phase 4
## Instructions for developer environment
In order to execute the SPA application you should follow the next steps:
1.	Install Docker Desktop.
2.	Create and account on Dockerhub.
3.	Open any shell of type "bash".
4.	Clone this repository using the command "git clone https://github.com/CodeURJC-DAW-2021-22/webapp1.git".
5.	Use command "cd" until you get to the folder "Docker".
6.	Execute the command "./create_image.sh DockerhubUsername/codeurjc-daw-2021-22-webapp1".
7.	Execute the command "docker-compose up" on the shell.
8.	When the app is running, open any browser and search "https://localhost:8443/new/". 

## SPA Classes and Templates Diagram

![diagram](ImagesPhase3/SPAdiagram.png)

## Group members participation
### María Esteban Sánchez
#### Textual description:
María implemented the diferent screens for the films and unified the in one, also, she made all the functionalities, like adding comments or delenting the film as well as the components. Moreover she created and implemented the comment service and implemented some functions in the film service.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Implementation of filmUnregistered | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/023dce2f31a81c5894df3ce7b95513697d0116eb | 
| #2            | Implementation of filmRegistered | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/4256725282f7784d00ddc824775ffb892c22e7aa | 
| #3            | Union of all the film screens | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/45d7e4a9d1beb9e88c9f74efe429d9d2581c6e8d | 
| #4            | Implementation of addComment and editComment | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/11858bb3b9778ed704e404183bfac1556366e719 | 
| #5            | Implementation of deleteComment and load moreComments | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/778613e22dfc6256a0e04d09d06fe85a50c97fe7 | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [CommentServiceComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/services/comment.service.ts)     | 
| #2            | [AddCommentComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/comments/addComment.component.ts)     | 
| #3            | [AddComponent.html](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/comments/addComment.component.html)     | 
| #4            | [FilmComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/films/film.component.ts)     | 
| #5            | [FilmComponent.html](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/films/film.component.html)     | 

### Miguel Regato Herrero
#### Textual description:
Miguel created the user service and also the most part of the HTML and TypeScript files of users components.

#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | User Service					   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/6b3ec1da7b8d99fcbb3e539f0c985aaa0f08412a | 
| #2            | Edit Password Component			   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/7da48db2ca7d221a2e6421b26e24eb00d37feea4 | 
| #3            | Edit Profile Component		   	   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/7da96b86d3d12c0d5ff7abc7eb83922fe3ffb0a0 | 
| #4            | Followers Component				   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/4ac5ee5e391fb6c35c4b326406d098776cc39977 | 
| #5            | Following Component				   | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/5833d2add8cb45157cc205dfe943275698a07c67 | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [UserServiceComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/services/user.service.ts)     | 
| #2            | [EditPasswordComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/users/editPassword.component.ts)     | 
| #3            | [EditProfileComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/users/editProfile.component.ts)     | 
| #4            | [FollowersComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/users/followers.component.ts)     | 
| #5            | [FollowingComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/users/following.component.ts)     | 

### Juan Carlos Moreno García
#### Textual description: Juan Carlos reimplemented the chart using the ngx-charts angular library. Moreover, he finished the user service, implemented the profile component, fixed important errors and refactored all the components.


#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | ng-bootstrap added and chart using ngx-charts	 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/451ccf586132ffa5225fa57ebe6deae7ed1f4375 | 
| #2            | UserService implemented					 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/d13412c557a91f432285d2efc1d7c7c916da06b3 | 
| #3            | profile implemented					 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/092fa144a5bc791d6e36f309fd9854f27a9727cc | 
| #4            | Some important changes					 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/0788a2980a9e80881bd8c4f6cb2d168349ce86c9 | 
| #5            | Header unified and some errors fixed		 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/ca2fe35b76f75ceb272bbce05ff9435c81c67cbb | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [menu.component](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/menu/menu.component.html)     | 
| #2            | [user.service](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/services/user.service.ts)     | 
| #3            | [profile.component](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/users/profile.component.ts)     | 
| #4            | [login.service](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/services/login.service.ts)     | 
| #5            | [profile.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/users/profile.component.html)     | 

### Héctor Fernández Martínez
#### Textual description:
Hector made components such as postfilm, login and register user. He was in charge the application SPA.


#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Post Film							 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/37f933eb207aee811e45a23cc3f60084adade723 | 
| #2            | Register User						 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/a449c2866be82fc2b4529f97103acc05e2e5855d | 
| #3            | Login User and Login Service				 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/28bcdbe566a647cca4710c86c8f61bff575db9c7 | 
| #4            | SPAController						 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/97bfbd57ff3a54458d323d601b711394baa68569 | 
| #5            | Create_image						 | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/200f1ecb2fc7980a62cade491859bec44ac1e1d8 | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [Login](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/login/login.component.ts)     | 
| #2            | [Register](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/login/register.component.ts)     | 
| #3            | [AddFilm](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/films/addFilm.component.ts)     | 
| #4            | [Create_image](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/docker/create_image.sh)     | 
| #5            | [SPAController](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/backend/src/main/java/app/controller/SPAController.java)     | 

### Vanesa Reina Hernández
#### Textual description:
Vanesa created the html templates for the application, as well as their components and entity interfaces, she conected the API backend with the fronted. Moreover, she did the different menus with their functionalities (loadMore buttons and different links), unify them in only one menu, create the showPassword function in typeScript and the search films function and page.


#### The five most important commits:

| Commit number | Description                                      | Link                                                                                            |
| ------------- | ------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| #1            | Different templates and Components | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/e9980d6f1cbe33e39edabfde47d05fb084e34d2d | 
| #2            | Show password function, changed headers and watchProfile template| https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/8c7c0135a27ad7db88488c8ee3f8b1c35708821b | 
| #3            | Unification of menus | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/3bb397adfa731f7a347a6930e5e0ffb17dde4fdd | 
| #4            | MenuAdmin and MenuRegistered with loadMore buttons | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/de92cc446deb59cd0d78f14bbcc7800c9bf74caf | 
| #5            | SearchgFilms function | https://github.com/CodeURJC-DAW-2021-22/webapp1/commit/29a9f77ca1d5fb2d12a11571d04355c701d6abde | 


#### The five most participated files:

| Commit number | File               |
| ------------- | ------------------ |
| #1            | [MenuComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/menu/menu.component.ts)     | 
| #2            | [SearchFilmsComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/films/searchFilms.component.ts )     | 
| #3            | [FilmServiceComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/services/film.service.ts )     | 
| #4            | [EditPasswordComponent](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/users/editPassword.component.ts )     | 
| #5            | [MenuComponent.html](https://github.com/CodeURJC-DAW-2021-22/webapp1/blob/main/frontend/src/app/components/menu/menu.component.html)     |
