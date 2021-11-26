package com.example.spring.mongodb.gridfsbucket.api.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.model.Filters;

@RestController
public class BinaryController {	
	@Autowired
	private GridFSBucket gridFSBucket;
	
	private ObjectId fileId;
	
	@PostMapping("/save/{filename}")
	public String saveFile(@PathVariable String filename) {
		try {			
			File file = new File("C:/Users/hk_je/Downloads/mongodb_gridfs_template_test/" + filename);
			InputStream inputSteam = new FileInputStream(file);
			
			fileId = gridFSBucket.uploadFromStream(filename, inputSteam);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "File (" + filename + ") stored successfully with fileId " + fileId;
	}
	
	@GetMapping("/retrieve/{filename}")
	public String retrieveFile(@PathVariable String filename) {		
		try {			
			GridFSFindIterable gridFSFindIterable = gridFSBucket.find(Filters.eq("filename", filename));
		    GridFSFile gridFSFile = gridFSFindIterable.first();
		    
			FileOutputStream streamToDownloadTo = new FileOutputStream("C:/Users/hk_je/Downloads/mongodb_gridfs_template_test/tmp/" + filename);
		    gridFSBucket.downloadToStream(gridFSFile.getObjectId(), streamToDownloadTo);
		    streamToDownloadTo.close();		    
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return "File retrived with name : " + filename;
	}
	
	@DeleteMapping("/delete/{filename}")
	public String deleteFile(@PathVariable String filename) {	
		GridFSFindIterable gridFSFindIterable = gridFSBucket.find(Filters.eq("filename", filename));
	    GridFSFile gridFSFile = gridFSFindIterable.first();
	    gridFSBucket.delete(gridFSFile.getObjectId());
	    return "File deleted with name : " + filename;
	}
}