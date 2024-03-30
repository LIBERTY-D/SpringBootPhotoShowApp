package com.mukubvu.photoClone.controller;

import com.mukubvu.photoClone.model.Photo;
import com.mukubvu.photoClone.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;


@RestController
public class PhotosController {


    @Autowired
    private PhotoService photoService;


    @GetMapping(path = "/photos")
    public Iterable<Photo> get(){

        return  photoService.get();
    }
    @GetMapping(path = "/photos/{id}")
    public Photo get(@PathVariable Integer id){

        Photo photoFound = photoService.get(id);
       if(photoFound==null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
       }

        return photoFound;


    }
    @DeleteMapping(path = "/photos/{id}")
    public void delete(@PathVariable Integer id){

        photoService.delete(id);
    }

    @PostMapping(path = "/photos")
    public  Photo create(@RequestPart("data") MultipartFile multipartFile) throws IOException {
        return photoService.create(multipartFile.getOriginalFilename(), multipartFile.getBytes(),multipartFile.getContentType());
    }

}
