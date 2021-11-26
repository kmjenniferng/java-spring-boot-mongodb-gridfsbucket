# File saved/retrieved/deleted using Java, Spring Boot, MongoDB database

The purpose of this project is to create 3 RESTful APIs to perform the following actions in MongoDB database.
1. **Save a file**
2. **Retrieve a file**
3. **Delete a file**

## [GridFS](https://docs.mongodb.com/manual/core/gridfs/)

MongoDB provides GridFS for storing and retrieving files larger than 16MB. In this project, we will use GridFsBucket to save, retrieve, delete files.

## Instructions on running tests using POSTMAN
1. **Save a file**

HTTP:POST localhost:8080/save/{filename}

Headers: Key = Content-Type, Value = application/json

Expected test result: file will be saved into MongoDB database.

Example: HTTP:POST localhost:8080/save/bear.jpg

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot5.png">

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot1.png">

2. **Retrieve a file**

HTTP:GET localhost:8080/retrieve/{filename}

Headers: Key = Content-Type, Value = application/json

Expected test result: file will be retrieved from MongoDB database and saved into "C:\Users\hk_je\Downloads\mongodb_gridfs_template_test\tmp" folder

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot2.png">

3. **Delete a file**

HTTP:DELETE: localhost:8080/delete/{filename}

Headers: Key = Content-Type, Value = application/json

Expected test result: file will be deleted from MongoDB database.

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot4.png">

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot3.png">
