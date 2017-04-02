# Challenge
Write a small web application to store article information of a newspaper. This application should be able to handle all the CRUD operations. Also create REST API which allows the public to read latest 10 articles of a particular day. Use the following technologies for developing this application.

Article information should include article id, publication, published date, headline, content, author, modified date.

# Tools and Technologies
* **Build Tool:** Maven v3.3.3
* **Database:** MongoDB v3.4.0
* **Frontend framework:** AngularJS
* **Backend framework:** Spring v4.0
* **JDK version:** 1.8 
* **Communication Format:** JSON

# Functionalities
* Able to create a new article
* Able to modify fields of an existing article except code (article id), author and headline fields
* Able to delete an article
* Able to list all the articles available in the database
* Able to get given number of articles by published date 
* Able to see readonly view of an article 

# Need To Improve
* Field sorting on columns of the data-table
* Pagination for the data-table 
* Add appropriate logger messages
* Validations in certain scenarios

# REST API end points
* `GET` `/api/articles` - Get all the articles
* `GET` `/api/articles/{id}` - Get an article by id
* `GET` `/api/articles/{dd-MM-yyyy}/{count}` - Get the latest articles for certain date. For example, to get 5 articles on date 01-04-2017, `/api/articles/01-04-2017/5`
* `POST` `/api/articles` - Save a new article
* `PUT` `/api/articles/{id}` - Update an article by id
* `DELETE` `/api/articles/{id}` - Remove an article by id

# Assumptions
- An article is written by one author
- `Article ID` is represented by `code`
- Article code is unique
- Security is not required 
- Article code, author and headline of the article would not be able to modify
- A mongod instance is running 
- Article created data is considered as the published date of the article
- Article edited date is considered as the modified date of the article.
 
# Setup

## Build
The application can be build for 3 environments, development, test and production.
* Development

Update `dev.properties` file under `environments` folder

Build using following command 
```
mvn clean install -P dev -DskipTests 
```
Deployment artifact is `sph-dev.war` under `target` folder
 
* Test

Update `test.properties` file under `environments` folder

Build using following command 
```
mvn clean install -P test -DskipTests 
```
Deployment artifact is `sph-test.war` under `target` folder

* Production

Update `prod.properties` file under `environments` folder

Build using following command 
```
mvn clean install -P prod -DskipTests 
```
Deployment artifact is `sph.war` under `target` folder


## Seed data 
To setup seed data, run following shell script under `db` folder. Follow the instructions given in the shell script before execute it.
```
sh import-seed.sh
``` 

## Deploy
Deploy the war file on a web server

# To Run Tests
```
mvn -Dtest=TestArticleService test
``` 

# Access the application
e.g http://localhost:8080/sph-dev/