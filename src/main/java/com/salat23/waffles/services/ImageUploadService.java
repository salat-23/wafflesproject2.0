package com.salat23.waffles.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.salat23.waffles.models.ImageResource;
import com.salat23.waffles.models.series.Series;
import com.salat23.waffles.repository.ImageResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageUploadService {

    private final ImageResourceRepository imageResourceRepository;
    private final Cloudinary cloudinary;

    public ImageUploadService(ImageResourceRepository imageResourceRepository, Cloudinary cloudinary) {
        this.imageResourceRepository = imageResourceRepository;
        this.cloudinary = cloudinary;
    }

    public ImageResource uploadImage(MultipartFile file) throws IOException {
        File coverImage = Files.createTempFile("tempCover", UUID.randomUUID().toString()).toFile();
        file.transferTo(coverImage);
        Map uploadResult = cloudinary.uploader().upload(coverImage, ObjectUtils.emptyMap());
        ImageResource imageResource = new ImageResource();
        imageResource.setUrl((String) uploadResult.get("secure_url"));
        imageResource.setPublicId((String) uploadResult.get("public_id"));
        imageResource.setHeight((int) uploadResult.get("height"));
        imageResource.setWidth((int) uploadResult.get("width"));
        imageResourceRepository.save(imageResource);
        return imageResource;
    }

    public Series changeSeriesCover(Series series, ImageResource imageResource) throws IOException {
        ImageResource oldCover = series.getCover();
        Map destroyResult = cloudinary.uploader().destroy(oldCover.getPublicId(), Collections.emptyMap());
        System.out.println(destroyResult);
        imageResourceRepository.delete(oldCover);
        series.setCover(imageResource);
        return series;
    }

}
