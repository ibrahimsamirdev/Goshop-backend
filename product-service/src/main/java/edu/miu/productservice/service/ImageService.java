package edu.miu.productservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadOnePhoto(long vendprId, MultipartFile imageFile);
}
