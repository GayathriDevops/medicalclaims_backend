package com.hcl.helathcare.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * to upload file
 * @author sravya
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UploadFileController {
	
	/**
	 * @param file
	 * @return String - successfully uploaded
	 * file is uploaded in local 
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		
		File convertFile = new File("C:/Users/User1/sravya/newfiles/"+ file.getOriginalFilename());
		convertFile.createNewFile();
			try (FileOutputStream fileOut = new FileOutputStream(convertFile)) {
				fileOut.write(file.getBytes());
			}catch (Exception e) {
				e.getMessage();
			}
		return "file has uploaded successfully";
	}

}
