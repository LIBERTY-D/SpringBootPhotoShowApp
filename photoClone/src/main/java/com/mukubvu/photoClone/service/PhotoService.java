package com.mukubvu.photoClone.service;

import com.mukubvu.photoClone.model.Photo;
import com.mukubvu.photoClone.repository.PhotoRepo;
import org.springframework.stereotype.Service;


@Service
public class PhotoService {

    private final PhotoRepo photoRepo;

    public PhotoService(PhotoRepo photoRepo) {
        System.out.println("INITIALIZE");
        this.photoRepo = photoRepo;
    }

    public Iterable<Photo> get(){
        System.out.println("init");
        return  photoRepo.findAll();
    }

    public Photo get(Integer id) {
        return  photoRepo.findById(id).orElse(null);

    }

    public void delete(Integer id) {
          photoRepo.deleteById(id);

    }

    public Photo create(String fileName, byte[] data, String contentType) {
        Photo photo = new Photo();
        photo.setData(data);
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photoRepo.save(photo);
        return  photo;
    }
}
