package com.salat23.wafflesfullstack.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.salat23.wafflesfullstack.entity.CloudImage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@Service
public class CloudUploadService {

    private Cloudinary cloudinary;

    public CloudImage uploadMultipartFile(MultipartFile pic) {

        try {
            //Creating temporary file and transferring our multipart data to it;
            File coverImage = Files.createTempFile("tempPic", pic.getOriginalFilename()).toFile();
            pic.transferTo(coverImage);

            //Upload our temp file and get necessary attributes from the response;
            Map uploadResult = cloudinary.uploader().upload(coverImage, ObjectUtils.emptyMap());

            String publicId = (String) uploadResult.get("public_id");
            String url = (String) uploadResult.get("url");
            String secureUrl = (String) uploadResult.get("secure_url");

            CloudImage cloudImage = new CloudImage();
            cloudImage.setData(publicId, url, secureUrl);
            return cloudImage;
        } catch (IOException ex) {
            return null;
        }

    }


}
