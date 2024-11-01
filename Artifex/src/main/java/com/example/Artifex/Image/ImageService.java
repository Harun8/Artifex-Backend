package com.example.Artifex.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private static ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    public static List<Image> getImages() {
        List<Image> images = imageRepository.findAll();

        // Convert each image's byte array to a base64 string
        images.forEach(image -> {
            if (image.getImageData() != null) {
                // Convert byte[] to Base64 string
                String base64Image = Base64.getEncoder().encodeToString(image.getImageData());
                image.setBase64Image(base64Image);
            }
        });

        return images;
    }    }


