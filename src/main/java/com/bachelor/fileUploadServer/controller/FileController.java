package com.bachelor.fileUploadServer.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bachelor.fileUploadServer.service.FileService;

@Controller
public class FileController {

	@Autowired
	FileService fileService;

	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println("Done ");
		String path = fileService.uploadFile(file);
		return new ResponseEntity<String>(path, HttpStatus.OK);
	}
		
	@PostMapping("/uploadFiles")
	public String uploadFiles(@RequestParam("files") MultipartFile[] files) {
		Arrays.asList(files).stream().forEach(file -> fileService.uploadFile(file));
		return "Done";
	}
}
