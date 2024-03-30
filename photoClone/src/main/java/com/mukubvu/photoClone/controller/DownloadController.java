package com.mukubvu.photoClone.controller;

import com.mukubvu.photoClone.service.PhotoService;
import com.mukubvu.photoClone.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {


    @Autowired
    private PhotoService photoService;
    @GetMapping(path = "/download/{id}")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if(photo ==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        byte[] data=photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        //attachment ->for download
        // inline -> for preview in browser
        ContentDisposition contentDisposition =  ContentDisposition.builder("attachment").filename(photo.getFileName()).build();
        headers.setContentDisposition(contentDisposition);
        return new ResponseEntity<>(data,headers, HttpStatus.OK);
    }
}
