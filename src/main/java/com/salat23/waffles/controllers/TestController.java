package com.salat23.waffles.controllers;

import com.salat23.waffles.security.services.ImageUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {

	private final ImageUploadService imageUploadService;

	public TestController(ImageUploadService imageUploadService) {
		this.imageUploadService = imageUploadService;
	}

	@PostMapping("/upload")
	public void upload(@RequestParam("file") MultipartFile file) {
		imageUploadService.uploadImage(file);
	}

}
