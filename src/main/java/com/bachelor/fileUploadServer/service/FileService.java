package com.bachelor.fileUploadServer.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bachelor.fileUploadServer.config.CONSTANTS;
import com.bachelor.fileUploadServer.exception.FileStorageException;

@Service
public class FileService {
	@Autowired
	RestTemplate restTemplate;

	public String uploadFile(MultipartFile file) {
		String path = getTheTempFolderDirectory();
		try {
			moveTheFileToTheDirectory(file, path);
		} catch (Exception e) {
			exceptionHandler(e, file);
		}
		return path+file.getOriginalFilename();
		

		
	}

	private void moveTheFileToTheDirectory(MultipartFile file, String uploadDir) throws IOException {
		Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
		Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
	}

	private String getTheTempFolderDirectory() {
		ResponseEntity<String> response = restTemplate.getForEntity(CONSTANTS.URL, String.class);
		return response.getBody();
	}

	private void exceptionHandler(Exception e, MultipartFile file) {
		e.printStackTrace();
		throw new FileStorageException(
				"Could not store the file " + file.getOriginalFilename() + ". Please try again!");
	}

}
