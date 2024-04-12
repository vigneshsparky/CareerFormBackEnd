package com.career.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface FileStorageService {
	public void init();

	  public static void save(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	  public Resource load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
}
