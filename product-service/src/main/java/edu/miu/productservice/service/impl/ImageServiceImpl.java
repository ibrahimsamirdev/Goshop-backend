package edu.miu.productservice.service.impl;

import edu.miu.productservice.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${prefix.imagesUrl}")
    private String imagesDir;


    @Override
    public String uploadOnePhoto(long vendprId, MultipartFile imageFile) {

        StringBuilder publicUrl = new StringBuilder();
        publicUrl.append("http://localhost/goshop/").append(vendprId).append("/").append(imageFile.getOriginalFilename());
        File dirFile = new File(imagesDir+"/goshop");
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String curPathDir = imagesDir + "/goshop/" + vendprId  ;
        dirFile = new File(curPathDir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String curPath = curPathDir+ "/" + imageFile.getOriginalFilename();
        System.out.println("curPath " + curPath);
        File file = new File(curPath);
        try {
            imageFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return publicUrl.toString();
    }
}
