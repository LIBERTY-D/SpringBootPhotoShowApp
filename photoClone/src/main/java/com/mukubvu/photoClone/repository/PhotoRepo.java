package com.mukubvu.photoClone.repository;

import com.mukubvu.photoClone.model.Photo;
import org.springframework.data.repository.CrudRepository;


public interface PhotoRepo extends CrudRepository<Photo, Integer> {
}
