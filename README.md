# Binary File saved/retrieved/deleted using Java, Spring Boot, MongoDB, GridFsBucket

The purpose of this project is to create 3 RESTful APIs to perform the following actions in MongoDB database.
1. **Save a file**
2. **Retrieve a file**
3. **Delete a file**

## [GridFS](https://docs.mongodb.com/manual/core/gridfs/)

MongoDB provides GridFS for storing and retrieving files larger than 16MB. GridFS stores large binary files by breaking the files into smaller files called **chunks** and saving them in MongoDB. GridFS uses two collections called **fs.files** and **fs.chunks** to save a file into a database. The fs.chunks collection contains the binary file broken up into 255k chunks. The fs.files collection contains the metadata for the document.

## GridFS Structure
<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot7.png">

## Example
Each document in the **fs.files** collection is associated with a set of documents in the **fs.chunks** collection. The fs.chunks documents are numbered from 0 to n with binary data for the chunk stored in the data field. Each document in fs.files has its own _id and _id is related to files_id in fs.chunks. The following is the chunk associated with the document ObjectId 61a137e79375ad646308ca9c.

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot8.png">

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot9.png">

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

Expected test result: file will be retrieved from MongoDB database and saved it into "C:\Users\hk_je\Downloads\mongodb_gridfs_template_test\tmp" folder

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot2.png">

3. **Delete a file**

HTTP:DELETE: localhost:8080/delete/{filename}

Headers: Key = Content-Type, Value = application/json

Expected test result: file will be deleted from MongoDB database.

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot4.png">

<img src="https://github.com/kmjenniferng/java-spring-boot-mongodb-gridfsbucket/blob/main/screenshot3.png">
